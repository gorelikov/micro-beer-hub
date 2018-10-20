package bar.tender.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.http.annotation.Get;
import lombok.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("bar.pack")
public class BarConfiguration {
    private String beerType;
    private Integer packSize;
    private Integer packPrice;
    private Integer tableSize;

    @Getter(AccessLevel.PRIVATE)
    private Integer minPackSize;
    @Getter(AccessLevel.PRIVATE)
    private Integer maxPackSize;
    @Getter(AccessLevel.PRIVATE)
    private Integer minPrice;
    @Getter(AccessLevel.PRIVATE)
    private Integer maxPrice;
    @Getter(AccessLevel.PRIVATE)
    private List<String> beerTypes;
    @Getter(AccessLevel.PRIVATE)
    private Integer minTableSize;
    @Getter(AccessLevel.PRIVATE)
    private Integer maxTableSize;

    @PostConstruct
    public void init() {
        Random rnd = new Random();
        beerType = beerTypes.get(rnd.nextInt(beerTypes.size() -1 ));
        packSize = rnd.nextInt((maxPackSize - minPackSize) + 1) + minPackSize;
        packPrice = rnd.nextInt((maxPrice - minPrice) + 1) + minPrice;
        tableSize = rnd.nextInt((maxTableSize - minTableSize) + 1) + minTableSize;
    }
}
