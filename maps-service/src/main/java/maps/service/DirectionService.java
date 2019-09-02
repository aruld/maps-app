package maps.service;

import io.reactivex.Single;
import maps.common.DirectionDTO;
import maps.common.LatLngPair;
import maps.common.MapProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class DirectionService {

    private static final Logger LOG = LoggerFactory.getLogger(DirectionService.class);

    @Inject
    private DirectionRepository directionRepository;

    @Inject
    private LatLngRepository latLngRepository;

    public Single<List<DirectionDTO>> getDirections(MapProvider provider, LatLngPair latLngPair) {

        LOG.info("Requesting directions from provider {} for co-ordinates : {}", provider, latLngPair);
        List<DirectionDTO> directions = directionRepository.findDirections(latLngPair.getSrc().getPlace(), latLngPair.getDest().getPlace()).stream().map(direction -> new DirectionDTO(direction.getPosition(), direction.getText(), direction.getDistanceInMiles(), direction.getTimeInMinutes())).collect(Collectors.toList());
        return Single.just(directions);
    }
}