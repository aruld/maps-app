package maps.service;

import io.micronaut.context.event.StartupEvent;
import maps.common.Direction;
import maps.common.LatLng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Bootstrap {

    private static final Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    @Inject
    DirectionRepository directionRepository;

    @Inject
    LatLngRepository latLngRepository;

    void onStartup(StartupEvent event) {
        LOG.info("Bootstrapping sample data for maps ...");
        latLngRepository.save(new LatLng(37.331699, -122.030190, Places.apple.name()));
        latLngRepository.save(new LatLng(37.423199, -122.084068, Places.google.name()));
        directionRepository.save(new Direction(0, "Get on I-280 N from N De Anza Blvd", 0.5, 3L));
        directionRepository.save(new Direction(1, "Take CA-85 N to Rengstorff Ave in Mountain View. Take exit 400A from US-101 N", 8.1, 8L));
        directionRepository.save(new Direction(2, "Take Amphitheatre Pkwy to your destination", 0.5, 3L));
    }
}
