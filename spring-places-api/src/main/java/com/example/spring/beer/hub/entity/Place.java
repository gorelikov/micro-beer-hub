package com.example.spring.beer.hub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
@CompoundIndex(def = "{ averagePrice: 1, maxTableSize: 1 }", background = true)
public class Place {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private Integer averagePrice;//yeah, i know that int is not good for price, but it's just demo
    private Integer maxTableSize;
}
