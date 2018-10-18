package com.example.spring.beer.hub;

import com.example.spring.beer.hub.entity.Offer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableRedisRepositories
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Offer> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Offer> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(Offer.class));
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
