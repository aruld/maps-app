package maps.service;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import maps.common.LatLngDTO;
import maps.common.Place;

@Client("/")
public interface GeoClient {

    @Get("/places/{place}")
    Single<LatLngDTO> getLatLng(Place place);

}