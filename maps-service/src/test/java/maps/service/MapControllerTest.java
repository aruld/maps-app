package maps.service;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import maps.common.DirectionDTO;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

import static org.junit.Assert.assertEquals;

@MicronautTest
public class MapControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeAll
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
    }

    @AfterAll
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void getDirections() {
        List<DirectionDTO> directions = client.toBlocking().retrieve(HttpRequest.GET("/apple?src=apple&dest=google"), Argument.listOf(DirectionDTO.class));
        assertEquals(6, directions.size());

        directions = client.toBlocking().retrieve(HttpRequest.GET("/fastest?src=apple&dest=google"), Argument.listOf(DirectionDTO.class));
        assertEquals(6, directions.size());
    }

}
