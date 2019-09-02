package maps.service.model;

import maps.common.MapProvider;
import maps.common.Place;

import javax.persistence.*;

@Entity
public class Direction {

    @Id
    @GeneratedValue
    private Long id;

    public Direction() {
    }

    public Direction(MapProvider provider, Place start, Place end, Integer position, String text, Double distanceInMiles, Long timeInMinutes) {
        this.provider = provider;
        this.start = start;
        this.end = end;
        this.position = position;
        this.text = text;
        this.distanceInMiles = distanceInMiles;
        this.timeInMinutes = timeInMinutes;
    }

    private MapProvider provider;
    private Place start;
    private Place end;

    private Integer position;

    private String text;

    private Double distanceInMiles;

    private Long timeInMinutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MapProvider getProvider() {
        return provider;
    }

    public void setProvider(MapProvider provider) {
        this.provider = provider;
    }

    public Place getStart() {
        return start;
    }

    public void setStart(Place start) {
        this.start = start;
    }

    public Place getEnd() {
        return end;
    }

    public void setEnd(Place end) {
        this.end = end;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(Double distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
    }

    public Long getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(Long timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }
}