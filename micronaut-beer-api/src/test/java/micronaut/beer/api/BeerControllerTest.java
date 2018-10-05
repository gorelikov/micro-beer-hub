package micronaut.beer.api;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class BeerControllerTest {

    @Test
    public void testIndex() throws Exception {
        try (EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class)) {
            try (RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
                assertEquals(HttpStatus.CREATED, client.toBlocking().exchange(HttpRequest.POST("/beer", "{}")).status());
            }
        }
    }

}
