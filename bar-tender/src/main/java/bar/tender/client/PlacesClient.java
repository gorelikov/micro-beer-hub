package bar.tender.client;

import bar.tender.entity.Place;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client(id = "http://localhost:4568", path = "/place")
public interface PlacesClient {
    @Post(consumes = MediaType.APPLICATION_JSON)
    String savePlace(@Body Place place);
}
