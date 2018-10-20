package micronaut.groovy.beer.api

import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands

import javax.inject.Singleton

@Singleton
class CompanionRepository {
    private final StatefulRedisConnection<String, String> connection
    private final RedisCommands<String, String> command
    private static final String KEY = "COMPANIONS"

    CompanionRepository(StatefulRedisConnection<String, String> connection) {
        this.connection = connection
        this.command = connection.sync()
    }

    void save(String name) {
        command.sadd(KEY, name)
    }

    Set<String> loadAll() {
        return command.smembers(KEY)
    }
}
