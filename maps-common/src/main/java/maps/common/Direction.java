package maps.common;

import lombok.Data;

@Data
public class Direction {

    private int order;
    private String text;
    private double distanceInMiles;
    private long timeInMinutes;

}