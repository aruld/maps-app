package maps.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.Single;
import maps.common.Direction;
import maps.common.LatLngPair;
import maps.common.MapProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static maps.service.MapsSampleData.appleToGoogle;
import static maps.service.MapsSampleData.googleToApple;

@Singleton
public class DirectionService {

    private static final Logger LOG = LoggerFactory.getLogger(DirectionService.class);

    private static ObjectMapper mapper = new ObjectMapper();

    private Map<LatLngPair, String> appleDirections = new HashMap<>();
    private Map<LatLngPair, String> googleDirections = new HashMap<>();

    public DirectionService() {
        LOG.info("Initializing sample data for maps ...");
        appleDirections.put(appleToGoogle, MapsSampleData.APPLE_MAPS_AAPL_HQ_TO_GOOG_HQ);
        appleDirections.put(googleToApple, MapsSampleData.APPLE_MAPS_GOOGL_HQ_TO_AAPL_HQ);
        googleDirections.put(appleToGoogle, MapsSampleData.GOOGLE_MAPS_AAPL_HQ_TO_GOOG_HQ);
        googleDirections.put(googleToApple, MapsSampleData.GOOGLE_MAPS_GOOG_HQ_TO_AAPL_HQ);
    }


    public Single<List<Direction>> getDirections(MapProvider provider, LatLngPair latLngPair) {

        LOG.info("Requesting directions from provider {} for co-ordinates : {}", provider, latLngPair);
        // mock up the response
        String json = provider.equals(MapProvider.google) ? googleDirections.get(latLngPair) : appleDirections.get(latLngPair);

        List<Direction> directions;

        try {
            directions = mapper.readValue(json, new TypeReference<List<Direction>>() {
            });
        } catch (IOException e) {
            LOG.error("Failed to bind json", e);
            return Single.error(e);
        }

        return Single.just(directions);
    }
}