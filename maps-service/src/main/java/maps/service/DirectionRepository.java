package maps.service;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import maps.common.Direction;

@JdbcRepository(dialect = Dialect.H2)
public interface DirectionRepository extends CrudRepository<Direction, Long> {

}
