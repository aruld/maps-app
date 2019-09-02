package maps.service;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import maps.common.LatLng;

@JdbcRepository(dialect = Dialect.H2)
public interface LatLngRepository extends CrudRepository<LatLng, Long> {
}
