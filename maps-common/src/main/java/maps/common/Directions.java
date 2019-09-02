package maps.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Directions {

    private List<DirectionDTO> directions;
    private Optional<Double> distanceInMiles;
    private Optional<Long> timeInMinutes;

}
