package com.example.spark.places.api;

import com.example.spark.places.api.controller.PlaceController;
import com.example.spark.places.api.repository.PlaceCodecProvider;
import com.example.spark.places.api.service.PlaceService;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import spark.utils.StringUtils;

import static spark.Spark.port;

public class SparkPlaceApplication {
    public static void main(String[] args) {
        String portStr = System.getenv("server.port");
        if(StringUtils.isEmpty(portStr))
            port(4568);
        else
            port(Integer.parseInt(portStr));
        final Gson gson = new Gson();
        final MongoDatabase mongoDatabase = mongo();
        new PlaceController(new PlaceService(mongoDatabase), gson);
    }

    @SneakyThrows
    private static MongoDatabase mongo() {
        String uri = System.getenv("MONGO_URI");
        String database;
        String [] parts = uri.split("/");
        if(parts.length > 1) {
            database = parts[parts.length - 1];
        } else {
            database = "places";
        }
        MongoClientOptions.Builder options = createMongoOptions();
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri, options));
        return mongoClient.getDatabase(database);
    }

    private static MongoClientOptions.Builder createMongoOptions() {
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                CodecRegistries.fromProviders(new PlaceCodecProvider()),
                MongoClient.getDefaultCodecRegistry());
        return MongoClientOptions
                .builder()
                .codecRegistry(codecRegistry);
    }
}
