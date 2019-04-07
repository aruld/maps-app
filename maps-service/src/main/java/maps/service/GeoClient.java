package maps.service;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import maps.common.LatLng;

@Client("/")
public interface GeoClient {

    @Get("/places/{place}")
    Single<LatLng> getLatLng(String place);

}