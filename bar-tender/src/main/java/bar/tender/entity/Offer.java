package bar.tender.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Builder.Default private String type = "IPA";
    @Builder.Default private Integer bottles = 0;
    @Builder.Default private Integer totalPrice = 0;
    private String placeId;
}
