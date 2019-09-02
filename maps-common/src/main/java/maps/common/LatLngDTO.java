package maps.common;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class LatLngDTO {
    private double lat;
    private double lng;
    private Place place;

    public LatLngDTO(double lat, double lng, Place place) {
        this.lat = lat;
        this.lng = lng;
        this.place = place;
    }

    public LatLngDTO() {
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
        return "LatLngDTO{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", place=" + place +
                '}';
    }
}
