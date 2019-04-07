package maps.service;

import io.reactivex.Single;
import maps.common.LatLng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class GeoService {

    private static final Logger LOG = LoggerFactory.getLogger(GeoService.class);

    public Single<LatLng> getLatLng(Places place) {
        LOG.info("Fetching latlng for {}", place);

        if (place.equals(Places.apple)) {
            return Single.just(MapsSampleData.apple);
        } else if (place.equals(Places.google)) {
            return Single.just(MapsSampleData.google);
        } else {
            return Single.error(new RuntimeException("Invalid place. Supported places are apple and google"));
        }
    }
}
