package maps.service.model;

import maps.common.Place;

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
    private Place place;

    public LatLng() {
    }

    public LatLng(double lat, double lng, Place place) {
        this.lat = lat;
        this.lng = lng;
        this.place = place;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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