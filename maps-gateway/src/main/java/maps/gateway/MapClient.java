package maps.gateway;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import maps.common.Compares;
import maps.common.Direction;
import maps.common.Directions;
import maps.common.MapProvider;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Client(id = "maps-service", path = "/maps")
public interface MapClient {

    @Get("/{provider}")
    Single<List<Direction>> map(@NotBlank MapProvider provider, @NotBlank @QueryValue String src, @NotBlank @QueryValue String dest);

    @Get("/compare")
    Single<Compares> compare(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest);

    @Get("/shortest")
    Single<Directions> shortest(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest);

    @Get("/fastest")
    Single<Directions> fastest(@NotBlank @QueryValue String src, @NotBlank @QueryValue String dest);
}