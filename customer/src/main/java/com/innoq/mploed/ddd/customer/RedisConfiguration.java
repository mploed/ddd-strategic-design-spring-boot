package com.innoq.mploed.ddd.customer;

import com.innoq.mploed.ddd.customer.domainevents.CustomerCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory cf){
        RedisTemplate<String,String> redisTemplate=new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
        redisTemplate.setKeySerializer(new Jackson2JsonRedisSerializer<CustomerCreatedEvent>(CustomerCreatedEvent.class));
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<CustomerCreatedEvent>(CustomerCreatedEvent.class));
        return redisTemplate;
    }
}
