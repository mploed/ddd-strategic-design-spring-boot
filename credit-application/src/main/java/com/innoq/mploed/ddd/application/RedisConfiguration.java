package com.innoq.mploed.ddd.application;

import com.innoq.mploed.ddd.application.domainevents.CreditApplicationApprovedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory cf){
        RedisTemplate<String,String> redisTemplate=new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
        redisTemplate.setKeySerializer(new Jackson2JsonRedisSerializer<CreditApplicationApprovedEvent>(CreditApplicationApprovedEvent.class));
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<CreditApplicationApprovedEvent>(CreditApplicationApprovedEvent.class));
        return redisTemplate;
    }
}
