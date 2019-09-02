package maps.service;

import io.reactivex.Single;
import maps.common.LatLngDTO;
import maps.common.Place;
import maps.service.model.LatLng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GeoService {

    private static final Logger LOG = LoggerFactory.getLogger(GeoService.class);

    @Inject
    private LatLngRepository latLngRepository;

    public Single<LatLngDTO> getLatLng(Place place) {
        LOG.info("Fetching latlng for {}", place);

        if (place.equals(Place.apple)) {
            return Single.just(toLatLngDTO(latLngRepository.find(Place.apple)));
        } else if (place.equals(Place.google)) {
            return Single.just(toLatLngDTO(latLngRepository.find(Place.google)));
        } else {
            return Single.error(new RuntimeException("Invalid place. Supported places are apple and google"));
        }
    }

    private LatLngDTO toLatLngDTO(LatLng latLng) {
        return new LatLngDTO(latLng.getLat(), latLng.getLng(), latLng.getPlace());
    }
}
