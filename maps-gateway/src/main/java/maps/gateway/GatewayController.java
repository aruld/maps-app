package maps.gateway;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;
import maps.common.Compares;
import maps.common.Direction;
import maps.common.Directions;
import maps.common.MapProvider;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller("/api/${api.version:v1}")
public class GatewayController {

    private final MapClient mapClient;

    public GatewayController(MapClient mapClient) {
        this.mapClient = mapClient;
    }

    @Get("/{provider}")
    public Single<List<Direction>> map(@NotBlank MapProvider provider, @NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        return mapClient.map(provider, src, dest);
    }

    @Get("/compare")
    public Single<Compares> compare(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        return mapClient.compare(src, dest);
    }

    @Get("/shortest")
    public Single<Directions> shortest(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        return mapClient.shortest(src, dest);
    }

    @Get("/fastest")
    public Single<Directions> fastest(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest) {
        return mapClient.fastest(src, dest);
    }


}