package com.example.spark.places.api.repository;

import com.example.spark.places.api.entity.Place;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class PlaceCodecProvider implements CodecProvider {
    public <T> Codec<T> get(Class<T> myClass, CodecRegistry codecRegistry) {
        if (myClass == Place.class) {
            return (Codec<T>) new PlaceDocCodec(codecRegistry);
        }
        return null;
    }
}