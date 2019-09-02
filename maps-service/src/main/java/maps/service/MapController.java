package maps.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;
import maps.common.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @Get("/{provider}")
    public Single<List<DirectionDTO>> map(@NotBlank MapProvider provider, @NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapService.map(provider, src, dest);
    }

    @Get("/compare")
    public Single<Compares> compare(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapService.compare(src, dest);
    }

    @Get("/shortest")
    public Single<Directions> shortest(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapService.shortest(src, dest);
    }

    @Get("/fastest")
    public Single<Directions> fastest(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapService.fastest(src, dest);
    }
}