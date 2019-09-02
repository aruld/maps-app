package maps.service;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import maps.common.MapProvider;
import maps.common.Place;
import maps.service.model.Direction;
import maps.service.model.LatLng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
public class Bootstrap implements ApplicationEventListener<ServerStartupEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    private static String googleHq = "1600 Amphitheatre Pkwy, Mountain View, CA 94043";
    private static String appleHq = "1 Infinite Loop, Cupertino, CA 95014";

    @Inject
    private DirectionRepository directionRepository;

    @Inject
    private LatLngRepository latLngRepository;

    public void onApplicationEvent(ServerStartupEvent event) {
        LOG.info("Bootstrapping sample app data ...");
        latLngRepository.save(new LatLng(37.331699, -122.030190, Place.apple));
        latLngRepository.save(new LatLng(37.423199, -122.084068, Place.google));

        directionRepository.saveAll(Arrays.asList(new Direction(MapProvider.google, Place.apple, Place.google, 0, "Get on I-280 N from N De Anza Blvd", 0.5, 3L),
                new Direction(MapProvider.google, Place.apple, Place.google, 1, "Take CA-85 N to Rengstorff Ave in Mountain View. Take exit 400A from US-101 N", 8.1, 8L),
                new Direction(MapProvider.google, Place.apple, Place.google, 2, "Take Amphitheatre Pkwy to your destination", 0.5, 3L)));

        directionRepository.saveAll(Arrays.asList(new Direction(MapProvider.google, Place.google, Place.apple, 0, "Get on US-101 S from Amphitheatre Pkwy and Rengstorff Ave", 1.0, 4L),
                new Direction(MapProvider.google, Place.google, Place.apple, 1, "Take CA-85 S to N De Anza Blvd in Cupertino. Take exit 11 from I-280 S", 8.2, 8L),
                new Direction(MapProvider.google, Place.google, Place.apple, 2, "Continue to N De Anza Blvd. Drive to Infinite Loop", 0.4, 2L)));

        directionRepository.saveAll(Arrays.asList(new Direction(MapProvider.apple, Place.apple, Place.google, 0, "Turn right onto N Shoreline Blvd", 0.3, 1L),
                new Direction(MapProvider.apple, Place.apple, Place.google, 1, "Take a slight right turn to merge onto CA-85 South", 0.6, 1L),
                new Direction(MapProvider.apple, Place.apple, Place.google, 2, "Keep left to merge onto CA-85 South", 0.2, 1L),
                new Direction(MapProvider.apple, Place.apple, Place.google, 3, "Take the exit to merge onto I-280 toward San Jose", 5.4, 6L),
                new Direction(MapProvider.apple, Place.apple, Place.google, 4, "Take exit 11 onto De Anza Boulevard", 1.5, 1L),
                new Direction(MapProvider.apple, Place.apple, Place.google, 5, "Turn right onto N De Anza Blvd toward Cupertino, Saratoga", 0.2, 1L),
                new Direction(MapProvider.apple, Place.apple, Place.google, 6, "Turn left onto Mariani Ave", 0.3, 1L)));

        directionRepository.saveAll(Arrays.asList(new Direction(MapProvider.apple, Place.google, Place.apple, 0, "Turn left to merge onto I-280 North", 0.2, 1L),
                new Direction(MapProvider.apple, Place.google, Place.apple, 1, "Take exit 12A to merge onto CA-85 North toward Mtn View", 1.0, 1L),
                new Direction(MapProvider.apple, Place.google, Place.apple, 2, "Take exit 24B on the left to merge onto US-101 North toward San Francisco", 5.5, 6L),
                new Direction(MapProvider.apple, Place.google, Place.apple, 3, "Take exit 400A toward Amphitheater Parkway", 1.6, 1L),
                new Direction(MapProvider.apple, Place.google, Place.apple, 4, "Take right onto Charleston Rd", 0.3, 1L),
                new Direction(MapProvider.apple, Place.google, Place.apple, 5, "Turn left", 0.4, 1L)));

        LOG.info("LatLng table count : {}", latLngRepository.count());
        LOG.info("Direction table count : {}", directionRepository.count());

        LOG.info("Bootstrapping sample app data done.");
    }
}
