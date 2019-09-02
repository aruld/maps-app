package maps.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatLngPair {

    private LatLngDTO src;
    private LatLngDTO dest;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatLngPair that = (LatLngPair) o;
        return src.equals(that.src) &&
                dest.equals(that.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest);
    }
}