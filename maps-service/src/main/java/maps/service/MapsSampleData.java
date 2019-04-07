package maps.service;

import maps.common.LatLng;
import maps.common.LatLngPair;

public class MapsSampleData {

    public static String GOOGLE_MAPS_AAPL_HQ_TO_GOOG_HQ = "[\n" +
            "  {\n" +
            "    \"order\": 0,\n" +
            "    \"text\": \"Get on I-280 N from N De Anza Blvd\",\n" +
            "    \"distanceInMiles\": 0.5,\n" +
            "    \"timeInMinutes\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 1,\n" +
            "    \"text\": \"Take CA-85 N to Rengstorff Ave in Mountain View. Take exit 400A from US-101 N\",\n" +
            "    \"distanceInMiles\": 8.1,\n" +
            "    \"timeInMinutes\": 8\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"text\": \"Take Amphitheatre Pkwy to your destination\",\n" +
            "    \"distanceInMiles\": 0.5,\n" +
            "    \"timeInMinutes\": 3\n" +
            "  }\n" +
            "]";

    public static String GOOGLE_MAPS_GOOG_HQ_TO_AAPL_HQ = "[\n" +
            "  {\n" +
            "    \"order\": 0,\n" +
            "    \"text\": \"Get on US-101 S from Amphitheatre Pkwy and Rengstorff Ave\",\n" +
            "    \"distanceInMiles\": 1.0,\n" +
            "    \"timeInMinutes\": 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 1,\n" +
            "    \"text\": \"Take CA-85 S to N De Anza Blvd in Cupertino. Take exit 11 from I-280 S\",\n" +
            "    \"distanceInMiles\": 8.2,\n" +
            "    \"timeInMinutes\": 8\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"text\": \"Continue to N De Anza Blvd. Drive to Infinite Loop\",\n" +
            "    \"distanceInMiles\": 0.4,\n" +
            "    \"timeInMinutes\": 2\n" +
            "  }\n" +
            "]";

    public static String APPLE_MAPS_AAPL_HQ_TO_GOOG_HQ = "[\n" +
            "  {\n" +
            "    \"order\": 0,\n" +
            "    \"text\": \"Turn right onto N Shoreline Blvd\",\n" +
            "    \"distanceInMiles\": 0.3,\n" +
            "    \"timeInMinutes\": 1\n" +
            "    \n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 1,\n" +
            "    \"text\": \"Take a slight right turn to merge onto CA-85 South\",\n" +
            "    \"distanceInMiles\": 0.6,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"text\": \"Keep left to merge onto CA-85 South\",\n" +
            "    \"distanceInMiles\": 0.2,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 3,\n" +
            "    \"text\": \"Take the exit to merge onto I-280 toward San Jose\",\n" +
            "    \"distanceInMiles\": 5.4,\n" +
            "    \"timeInMinutes\": 6\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 4,\n" +
            "    \"text\": \"Take exit 11 onto De Anza Boulevard\",\n" +
            "    \"distanceInMiles\": 1.5,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 5,\n" +
            "    \"text\": \"Turn right onto N De Anza Blvd toward Cupertino, Saratoga\",\n" +
            "    \"distanceInMiles\": 0.2,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 6,\n" +
            "    \"text\": \"Turn left onto Mariani Ave\",\n" +
            "    \"distanceInMiles\": 0.3,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  }\n" +
            "]";

    public static String APPLE_MAPS_GOOGL_HQ_TO_AAPL_HQ = "[\n" +
            "  {\n" +
            "    \"order\": 0,\n" +
            "    \"text\": \"Turn left to merge onto I-280 North\",\n" +
            "    \"distanceInMiles\": 0.2,\n" +
            "    \"timeInMinutes\": 1\n" +
            "    \n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 1,\n" +
            "    \"text\": \"Take exit 12A to merge onto CA-85 North toward Mtn View\",\n" +
            "    \"distanceInMiles\": 1.0,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"text\": \"Take exit 24B on the left to merge onto US-101 North toward San Francisco\",\n" +
            "    \"distanceInMiles\": 5.5,\n" +
            "    \"timeInMinutes\": 6\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 3,\n" +
            "    \"text\": \"Take exit 400A toward Amphitheater Parkway\",\n" +
            "    \"distanceInMiles\": 1.6,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 4,\n" +
            "    \"text\": \"Take right onto Charleston Rd\",\n" +
            "    \"distanceInMiles\": 0.3,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 5,\n" +
            "    \"text\": \"Turn left\",\n" +
            "    \"distanceInMiles\": 0.4,\n" +
            "    \"timeInMinutes\": 1\n" +
            "  }\n" +
            "]";

    private static String googleHq = "1600 Amphitheatre Pkwy, Mountain View, CA 94043";
    private static String appleHq = "1 Infinite Loop, Cupertino, CA 95014";
    public static LatLng apple = new LatLng(37.331699, -122.030190);
    public static LatLng google = new LatLng(37.423199, -122.084068);


    public static LatLngPair appleToGoogle = new LatLngPair(apple, google);
    public static LatLngPair googleToApple = new LatLngPair(google, apple);

}