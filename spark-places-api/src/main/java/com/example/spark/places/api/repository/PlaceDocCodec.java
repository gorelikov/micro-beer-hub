package com.example.spark.places.api.repository;

import com.example.spark.places.api.entity.Place;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;
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
            doc.setId(new ObjectId().toString());
        writer.writeObjectId("_id",new ObjectId(doc.getId()));
        writer.writeString("name", doc.getName());
        writer.writeInt32("averagePrice", doc.getAveragePrice());
        writer.writeInt32("maxTableSize", doc.getMaxTableSize());
        writer.writeEndDocument();
    }

    public Place decode(BsonReader reader, DecoderContext decoderContext) {
        Place.PlaceBuilder placeBuilder = Place.builder();
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            readField(reader, placeBuilder);
        }
        reader.readEndDocument();
        return placeBuilder.build();
    }

    private Place.PlaceBuilder readField(BsonReader reader, Place.PlaceBuilder placeBuilder) {
        String fieldName = reader.readName();
        switch (fieldName) {
            case "_id":
                return placeBuilder.id(reader.readObjectId().toString());
            case "name":
                return placeBuilder.name(reader.readString());
            case "averagePrice":
                return placeBuilder.averagePrice(reader.readInt32());
            case "maxTableSize":
                return placeBuilder.maxTableSize(reader.readInt32());
            default:{
                reader.skipValue();
                return placeBuilder;
            }

        }
    }

    public Class<Place> getEncoderClass() {
        return Place.class;
    }
}