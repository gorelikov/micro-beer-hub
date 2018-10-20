package bar.tender.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    private String id;

    private String name;
    private Integer averagePrice;//yeah, i know that int is not good for price, but it's just demo
    private Integer maxTableSize;
}
