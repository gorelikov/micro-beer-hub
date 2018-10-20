package com.example.spring.beer.hub.repository;

import java.util.Set;

public interface CompanionRepository {
    void save(String name);
    Set<String> loadAll();
}
