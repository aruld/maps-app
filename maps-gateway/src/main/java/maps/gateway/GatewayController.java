package maps.gateway;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import maps.common.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller("/api/maps")
public class GatewayController implements MapOperations {

    private final MapClient mapClient;

    public GatewayController(MapClient mapClient) {
        this.mapClient = mapClient;
    }

    @Get("/{provider}")
    @Operation(summary = "Find directions",
            tags = {"maps"},
            responses = {
                    @ApiResponse(description = "", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)))}
    )
    @ContinueSpan
    public Single<List<DirectionDTO>> map(@SpanTag("maps.provider") @NotBlank MapProvider provider, @SpanTag("maps.src") @NotBlank @QueryValue Place src, @SpanTag("maps.dest") @NotBlank @QueryValue Place dest) {
        return mapClient.map(provider, src, dest);
    }

    @Get("/compare")
    @Operation(summary = "Compare directions",
            tags = {"maps"},
            responses = {
                    @ApiResponse(description = "", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Compares.class)))}
    )
    public Single<Compares> compare(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapClient.compare(src, dest);
    }

    @Get("/shortest")
    @Operation(summary = "Find shortest route",
            tags = {"maps"},
            responses = {
                    @ApiResponse(description = "", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Directions.class)))}
    )
    public Single<Directions> shortest(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapClient.shortest(src, dest);
    }

    @Get("/fastest")
    @Operation(summary = "Find fastest route",
            tags = {"maps"},
            responses = {
                    @ApiResponse(description = "", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Directions.class)))}
    )
    public Single<Directions> fastest(@NotBlank @QueryValue Place src, @NotBlank @QueryValue Place dest) {
        return mapClient.fastest(src, dest);
    }
}