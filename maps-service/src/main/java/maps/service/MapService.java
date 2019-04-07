package maps.service;

import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;
import maps.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Singleton
public class MapService {

    private static final Logger LOG = LoggerFactory.getLogger(MapService.class);

    private final GeoClient geoClient;
    private final DirectionClient directionClient;

    public MapService(GeoClient geoClient, DirectionClient directionClient) {
        this.geoClient = geoClient;
        this.directionClient = directionClient;
    }

    public Single<List<Direction>> map(@NotBlank MapProvider provider, @NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        LOG.info("Mapping directions from {} to {} using provider {}", src, dest, provider);
        return getLatLngPair(src, dest).flatMap(pair -> directionClient.getDirections(provider, pair));
    }

    public Single<Compares> compare(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        LOG.info("Comparing directions from {} to {}", src, dest);
        return getLatLngPair(src, dest).flatMap(pair -> directionClient.getDirections(MapProvider.google, pair).zipWith(directionClient.getDirections(MapProvider.apple, pair), Compares::new));
    }

    public Single<Directions> shortest(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        LOG.info("Finding shortest route from {} to {}", src, dest);
        return getLatLngPair(src, dest).flatMap(pair -> findShortestRoute(directionClient.getDirections(MapProvider.google, pair), directionClient.getDirections(MapProvider.apple, pair)));
    }

    public Single<Directions> fastest(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        LOG.info("Finding fastest route from {} to {}", src, dest);
        return getLatLngPair(src, dest).flatMap(pair -> findFastestRoute( directionClient.getDirections(MapProvider.google, pair), directionClient.getDirections(MapProvider.apple, pair)));
    }

    private Single<LatLngPair> getLatLngPair(String src, String dest) {
        return Single.zip(geoClient.getLatLng(src), geoClient.getLatLng(dest), LatLngPair::new);
    }

    private Single<Directions> findShortestRoute(Single<List<Direction>> googleMapsDirections, Single<List<Direction>> appleMapsDirections) {
        return Single.zip(googleMapsDirections, appleMapsDirections, (googleDirections, appleDirections) -> {
                    double totalGoogleDistance = googleDirections.stream().mapToDouble(Direction::getDistanceInMiles).sum();
                    double totalAppleDistance = appleDirections.stream().mapToDouble(Direction::getDistanceInMiles).sum();
                    if (totalAppleDistance < totalGoogleDistance) {
                        return new Directions(appleDirections, Optional.of(totalAppleDistance), Optional.empty());
                    } else {
                        return new Directions(googleDirections, Optional.of(totalGoogleDistance), Optional.empty());
                    }
                }
        );
    }

    private Single<Directions> findFastestRoute(Single<List<Direction>> googleMapsDirections, Single<List<Direction>> appleMapsDirections) {
        return Single.zip(googleMapsDirections, appleMapsDirections, (googleDirections, appleDirections) -> {
                    long totalGoogleTime = googleDirections.stream().mapToLong(Direction::getTimeInMinutes).sum();
                    long totalAppleTime = appleDirections.stream().mapToLong(Direction::getTimeInMinutes).sum();
                    if (totalAppleTime < totalGoogleTime) {
                        return new Directions(appleDirections, Optional.empty(), Optional.of(totalAppleTime));
                    } else {
                        return new Directions(googleDirections, Optional.empty(), Optional.of(totalGoogleTime));
                    }
                }
        );
    }
}