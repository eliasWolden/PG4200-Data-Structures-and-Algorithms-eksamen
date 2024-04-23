package Utils;

public class City {
    private String name;
    private double latitude;
    private double longitude;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
    return longitude;}

    @Override
    public String toString() {
        return "[" + name + ", Latitude: " + String.format("%.4f", latitude) + ", Longitude: " + String.format("%.4f", longitude) + "]";
    }
}