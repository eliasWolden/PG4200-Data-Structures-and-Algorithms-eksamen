package MergeSort;

public class CoordinateComparator {
    public static int compareCoordinates(String lat1, String lon1, String lat2, String lon2) {
        double lat1Double = Double.parseDouble(lat1);
        double lon1Double = Double.parseDouble(lon1);
        double lat2Double = Double.parseDouble(lat2);
        double lon2Double = Double.parseDouble(lon2);

        double dist1 = haversine(lat1Double, lon1Double);
        double dist2 = haversine(lat2Double, lon2Double);

        if (dist1 < dist2)
            return -1;
        else if (dist1 > dist2)
            return 1;
        else
            return 0;
    }
    private static double haversine(double lat, double lon) {
        final double R = 6371.0;

        double latRad = Math.toRadians(lat);
        double lonRad = Math.toRadians(lon);

        double a = Math.sin(latRad / 2) * Math.sin(latRad / 2) +
                Math.cos(Math.toRadians(0)) * Math.cos(latRad) *
                        Math.sin(lonRad / 2) * Math.sin(lonRad / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c;
        return distance;
    }
}
