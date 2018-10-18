package com.example.spring.beer.hub.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RedisCompanionRepository implements CompanionRepository {
    public static final String KEY = "COMPANIONS";

    private final StringRedisTemplate redisTemplate;
    private SetOperations<String, String> setOperations;

    @PostConstruct
    private void init() {
        setOperations = redisTemplate.opsForSet();
    }

    @Override
    public void save(String name) {
        setOperations.add(KEY, name);
    }

    @Override
    public Set<String> loadAll() {
        return setOperations.members(KEY);
    }
}
