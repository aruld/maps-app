package maps.service;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import maps.common.DirectionDTO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void testDirections() {
        List<DirectionDTO> directions = client.toBlocking().retrieve(HttpRequest.GET("/apple?src=apple&dest=google"), Argument.listOf(DirectionDTO.class));
        assertEquals(6, directions.size());

        directions = client.toBlocking().retrieve(HttpRequest.GET("/fastest?src=apple&dest=google"), Argument.listOf(DirectionDTO.class));
        assertEquals(7, directions.size());
    }

}
