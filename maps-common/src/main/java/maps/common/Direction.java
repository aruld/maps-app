package maps.common;


import javax.persistence.*;

@Entity
public class Direction {

    @Id
    @GeneratedValue
    private Long id;

    public Direction() {
    }

    public Direction(Integer order, String text, Double distanceInMiles, Long timeInMinutes) {
        this.order = order;
        this.text = text;
        this.distanceInMiles = distanceInMiles;
        this.timeInMinutes = timeInMinutes;
    }

    private Integer order;

    private String text;

    private Double distanceInMiles;

    private Long timeInMinutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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