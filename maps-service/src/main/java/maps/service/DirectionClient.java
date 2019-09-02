package maps.service;

import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import maps.common.DirectionDTO;
import maps.common.LatLngPair;
import maps.common.MapProvider;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Client("/")
public interface DirectionClient {

    @Post("/directions/{provider}")
    Single<List<DirectionDTO>> getDirections(@NotBlank MapProvider provider, LatLngPair latLngPair);

}
