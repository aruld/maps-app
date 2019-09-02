package maps.gateway;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;
import maps.common.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface MapOperations {
    @Get("/{provider}")
    Single<List<DirectionDTO>> map(@NotBlank MapProvider provider, @NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest);

    @Get("/compare")
    Single<Compares> compare(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest);

    @Get("/shortest")
    Single<Directions> shortest(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest);

    @Get("/fastest")
    Single<Directions> fastest(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest);
}
