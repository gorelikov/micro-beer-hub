package com.example.spark.places.api.entity;

import com.mongodb.BasicDBObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    private String id;

    private String name;
    private Integer averagePrice;//yeah, i know that int is not good for price, but it's just demo
    private Integer maxTableSize;

    public Place(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.name = dbObject.getString("name ");
        this.averagePrice = dbObject.getInt("averagePrice ");
        this.maxTableSize = dbObject.getInt("maxTableSize ");
    }
}
