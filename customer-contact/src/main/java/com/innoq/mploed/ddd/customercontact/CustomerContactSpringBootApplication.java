package com.innoq.mploed.ddd.customercontact;

import com.innoq.mploed.ddd.customercontact.events.CreditApplicationApprovedEvent;
import com.innoq.mploed.ddd.customercontact.events.SendContractMessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootApplication
public class CustomerContactSpringBootApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerContactSpringBootApplication.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("credit-application-approved-events"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(SendContractMessageReceiver receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receiveMessage");
        messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<CreditApplicationApprovedEvent>(CreditApplicationApprovedEvent.class));
        return messageListenerAdapter;
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(CustomerContactSpringBootApplication.class, args);
    }
}
