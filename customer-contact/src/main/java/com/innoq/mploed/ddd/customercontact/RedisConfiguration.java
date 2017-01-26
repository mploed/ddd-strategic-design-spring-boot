package com.innoq.mploed.ddd.customercontact;

import com.innoq.mploed.ddd.customercontact.events.CreditApplicationApprovedEvent;
import com.innoq.mploed.ddd.customercontact.events.CreditApplicationDeclinedEvent;
import com.innoq.mploed.ddd.customercontact.events.CustomerCreatedEvent;
import com.innoq.mploed.ddd.customercontact.receiver.CreditApplicationApprovedEventReceiver;
import com.innoq.mploed.ddd.customercontact.receiver.CreditApplicationDeclinedEventReceiver;
import com.innoq.mploed.ddd.customercontact.receiver.CustomerCreatedEventReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            CreditApplicationApprovedEventReceiver applicationApprovedEventReceiver,
                                            CreditApplicationDeclinedEventReceiver applicationDeclinedEventReceiver,
                                            CustomerCreatedEventReceiver customerCreatedEventReceiver) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        container.addMessageListener(creditApplicationApprovedMessageListener(applicationApprovedEventReceiver),
                new PatternTopic("credit-application-approved-events"));

        container.addMessageListener(creditApplicationDeclinedMessageListener(applicationDeclinedEventReceiver),
                new PatternTopic("credit-application-declined-events"));

        container.addMessageListener(customerCreatedMessageListener(customerCreatedEventReceiver),
                new PatternTopic("customer-created-events"));
        return container;
    }

    @Bean
    MessageListenerAdapter creditApplicationApprovedMessageListener(CreditApplicationApprovedEventReceiver receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receiveMessage");
        messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<CreditApplicationApprovedEvent>(CreditApplicationApprovedEvent.class));
        return messageListenerAdapter;
    }

    @Bean
    MessageListenerAdapter creditApplicationDeclinedMessageListener(CreditApplicationDeclinedEventReceiver receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receiveMessage");
        messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<CreditApplicationDeclinedEvent>(CreditApplicationDeclinedEvent.class));
        return messageListenerAdapter;
    }

    @Bean
    MessageListenerAdapter customerCreatedMessageListener(CustomerCreatedEventReceiver receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receiveMessage");
        messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<CustomerCreatedEvent>(CustomerCreatedEvent.class));
        return messageListenerAdapter;
    }

}
