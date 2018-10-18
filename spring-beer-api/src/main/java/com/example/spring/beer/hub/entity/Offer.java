package com.example.spring.beer.hub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class Offer {
    @Builder.Default private String type = "IPA";
    @Builder.Default private Integer bottles = 0;
    @Builder.Default private Integer totalPrice = 0;
    private String placeId;
    private Place place;
}
