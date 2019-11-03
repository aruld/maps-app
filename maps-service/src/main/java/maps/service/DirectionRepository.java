package maps.service;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import maps.common.DirectionDTO;
import maps.common.MapProvider;
import maps.common.Place;
import maps.service.model.Direction;

import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface DirectionRepository extends CrudRepository<Direction, Long> {

    List<DirectionDTO> findByStartAndEndAndProviderOrderByPositionAsc(Place start, Place end, MapProvider provider);

    // this works, not the DTO variant above
    //List<Direction> findByStartAndEndAndProviderOrderByPositionAsc(Place start, Place end, MapProvider provider);
}
