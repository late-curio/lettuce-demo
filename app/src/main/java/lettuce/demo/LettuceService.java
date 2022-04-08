package lettuce.demo;

import com.newrelic.api.agent.Trace;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Map;

public class LettuceService {

    private final StatefulRedisConnection<String, String> connection;

    public LettuceService() {
        RedisClient redisClient = RedisClient
                .create("redis://localhost:6379/");
        this.connection = redisClient.connect();
    }

    @Trace(dispatcher = true)
    public void doEet() {
        System.out.println(connection.isOpen());

        if(!connection.isOpen()) {
            System.err.println("Lettuce connect is NOT open");
            System.exit(-1);
        }

        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Goodbye, Redis!");

        String value = syncCommands.get("key");

//        System.out.println(value);

        syncCommands.hset("recordName", "FirstName", "John");
        syncCommands.hset("recordName", "LastName", "Smith");

        Map<String, String> record = syncCommands.hgetall("recordName");

//        System.out.println(record);
    }
}
