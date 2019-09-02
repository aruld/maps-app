package maps.common;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class DirectionDTO {

    private Integer position;

    private String text;

    private Double distanceInMiles;

    private Long timeInMinutes;

    public DirectionDTO() {
    }

    public DirectionDTO(Integer position, String text, Double distanceInMiles, Long timeInMinutes) {
        this.position = position;
        this.text = text;
        this.distanceInMiles = distanceInMiles;
        this.timeInMinutes = timeInMinutes;
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

    @Override
    public String toString() {
        return "DirectionDTO{" +
                "position=" + position +
                ", text='" + text + '\'' +
                ", distanceInMiles=" + distanceInMiles +
                ", timeInMinutes=" + timeInMinutes +
                '}';
    }
}
