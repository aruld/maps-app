package maps.service;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import maps.common.DirectionDTO;
import maps.common.Place;
import maps.service.model.Direction;

import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface DirectionRepository extends CrudRepository<Direction, Long> {

    @Query("select * from direction d where d.start=:start and d.end=:end order by d.position")
    List<Direction> findDirections(Place start, Place end);
}
