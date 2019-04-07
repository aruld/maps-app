package maps.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import maps.common.LatLng;

@Controller
public class GeoController {

    private final GeoService geoService;

    public GeoController(GeoService geoService) {
        this.geoService = geoService;
    }

    @Get("/places/{place}")
    public Single<LatLng> getLatLng(Places place) {
        return geoService.getLatLng(place);
    }
}
