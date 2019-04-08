package maps.gateway;

import io.micronaut.http.client.annotation.Client;

@Client(id = "maps-service", path = "/maps")
public interface MapClient extends MapOperations {

}