package maps.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class LatLng {
    @Id
    @GeneratedValue
    private Long id;

    private double lat;
    private double lng;
    private String label;

    public LatLng() {
    }

    public LatLng(double lat, double lng, String label) {
        this.lat = lat;
        this.lng = lng;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatLng latLng = (LatLng) o;
        return Double.compare(latLng.lat, lat) == 0 &&
                Double.compare(latLng.lng, lng) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng);
    }
}