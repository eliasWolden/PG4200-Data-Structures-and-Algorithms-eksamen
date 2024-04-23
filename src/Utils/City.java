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

    /*
    * %.4f: formaterer flytall til fire desimaler*/
    @Override
    public String toString() {
        return "[" + name + ", Latitude: " + String.format("%.4f", latitude) + ", Longitude: " + String.format("%.4f", longitude) + "]";
    }

    /*@Override
    public String toString() {
        return "[" + name + ", Latitude: " + String.format("%.4f", latitude) + "]";
    }*/
}


/*
* public class City {
    // Instansvariabler for å lagre informasjon om byen
    private String name; // Navnet på byen
    private double latitude; // Breddegraden til byen
    private double longitude; // Lengdegraden til byen

    // Konstruktør for å opprette et nytt City-objekt med gitt navn, breddegrad og lengdegrad
    public City(String name, double latitude, double longitude) {
        this.name = name; // Setter navnet til det gitt navnet
        this.latitude = latitude; // Setter breddegraden til den gitt breddegraden
        this.longitude = longitude; // Setter lengdegraden til den gitt lengdegraden
    }

    // Metode for å hente navnet på byen
    public String getName() {
        return name; // Returnerer navnet på byen
    }

    // Metode for å hente breddegraden til byen
    public double getLatitude() {
        return latitude; // Returnerer breddegraden til byen
    }

    // Metode for å hente lengdegraden til byen
    public double getLongitude() {
        return longitude; // Returnerer lengdegraden til byen
    }

    // Metode for å returnere en strengrepresentasjon av City-objektet
    @Override
    public String toString() {
        // Returnerer en streng som inneholder navnet og breddegraden til byen med et spesifikt format
        return "[" + name + ", Latitude: " + String.format("%.4f", latitude) + "]";
    }
}
*/

