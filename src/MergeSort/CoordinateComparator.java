package MergeSort;

public class CoordinateComparator {
    //Bruker Haversine formelen for å kalkulere korrekt avstand
    public static int compareCoordinates(String lat1, String lon1, String lat2, String lon2) {
        // Convert latitude and longitude strings to doubles
        double lat1Double = Double.parseDouble(lat1);
        double lon1Double = Double.parseDouble(lon1);
        double lat2Double = Double.parseDouble(lat2);
        double lon2Double = Double.parseDouble(lon2);

        // Calculate distances using haversine formula
        double dist1 = haversine(lat1Double, lon1Double);
        double dist2 = haversine(lat2Double, lon2Double);

        // Compare distances
        if (dist1 < dist2)
            return -1;
        else if (dist1 > dist2)
            return 1;
        else
            return 0;
    }

    private static double haversine(double lat, double lon) {
        // Radius of the Earth in kilometers
        final double R = 6371.0;

        // Convert latitude and longitude from degrees to radians
        double latRad = Math.toRadians(lat);
        double lonRad = Math.toRadians(lon);

        // Haversine formula
        double a = Math.sin(latRad / 2) * Math.sin(latRad / 2) +
                Math.cos(Math.toRadians(0)) * Math.cos(latRad) *
                        Math.sin(lonRad / 2) * Math.sin(lonRad / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        double distance = R * c;
        return distance;
    }

}
