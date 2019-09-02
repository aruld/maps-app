package maps.service;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import maps.common.LatLngDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

@MicronautTest
public class GeoControllerTest {

    private static EmbeddedServer server;
    private static RequestSpecification requestSpec;

    @BeforeAll
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        requestSpec = new RequestSpecBuilder().setBaseUri(server.getURL().toString()).build();
    }

    @AfterAll
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
    }

    @ParameterizedTest
    @CsvSource({"apple, 37.331699, -122.030190", "google, 37.423199, -122.084068"})
    public void getLatLng(String hq, double latitude, double longitude) {
        LatLngDTO latLng =
                given().
                        spec(requestSpec).
                        pathParam("hq", hq).
                        when().
                        get("places/{hq}").
                        as(LatLngDTO.class);

        Assertions.assertEquals(latitude, latLng.getLat(), 0.1);
        Assertions.assertEquals(longitude, latLng.getLng(), 0.1);
    }

}
