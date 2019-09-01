package maps.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;
import maps.common.Direction;
import maps.common.LatLngPair;
import maps.common.MapProvider;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
public class DirectionController {

    private final DirectionService directionService;

    public DirectionController(DirectionService directionService) {
        this.directionService = directionService;
    }

    @Post("/directions/{provider}")
    public Single<List<Direction>> getDirections(@NotBlank MapProvider provider, LatLngPair latLngPair) {
        return directionService.getDirections(provider, latLngPair);
    }

}