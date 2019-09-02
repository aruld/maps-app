package maps.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compares {

    private List<DirectionDTO> google;
    private List<DirectionDTO> apple;
}