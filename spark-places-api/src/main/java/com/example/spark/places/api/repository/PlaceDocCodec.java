package com.example.spark.places.api.repository;

import com.example.spark.places.api.entity.Place;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import spark.utils.StringUtils;

import java.util.UUID;

class PlaceDocCodec implements Codec<Place> {

    private CodecRegistry codecRegistry;

    public PlaceDocCodec(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public void encode(BsonWriter writer, Place doc, EncoderContext encoderContext) {
        writer.writeStartDocument();
        if(StringUtils.isEmpty(doc.getId()))
            doc.setId(UUID.randomUUID().toString());
        writer.writeString("_id",doc.getId());
        writer.writeString("name", doc.getName());
        writer.writeInt32("averagePrice", doc.getAveragePrice());
        writer.writeInt32("maxTableSize", doc.getMaxTableSize());
        writer.writeEndDocument();
    }

    public Place decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartDocument();
        String id = reader.readString("_id");
        String name = reader.readString("name");
        Integer averagePrice = reader.readInt32("averagePrice");
        Integer maxTableSize = reader.readInt32("maxTableSize");
        reader.readEndDocument();

        return Place.builder()
                .id(id)
                .name(name)
                .averagePrice(averagePrice)
                .maxTableSize(maxTableSize)
                .build();
    }    

    public Class<Place> getEncoderClass() {
        return Place.class;
    }
}