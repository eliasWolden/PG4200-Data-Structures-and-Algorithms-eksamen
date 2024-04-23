package Utils;

import MergeSort.MergeSort;
import MergeSort.MergeSort1;
import QuickSort.QuickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWhich operation do you want to perform?");
            System.out.println("1. Perform Merge Sort");
            System.out.println("2. Perform Merge Sort with Latitude and Longitude");
            System.out.println("3. Perform Quick Sort");
            System.out.println("4. Perform Quick Sort with Longitude and Latitude");
            System.out.println("5. View all Cities");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    performMergeSort();
                    break;
                case 2:
                    performMergeSortWithLatitudeAndLongitude();
                    break;
                case 3:
                    performQuickSort();
                    break;
                case 4:
                    performQuickSortWithLongitudeAndLatitude();
                    break;
                case 5:
                    viewAllCities();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void performMergeSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV();
        System.out.println("Performing Merge Sort...");
        System.out.println("Regular merge sort:");
        System.out.println("Number of merges: " + result.getRegularMergeCount());
        System.out.println("\nShuffled merge sort:");
        System.out.println("Number of Merge sorts: " + result.getShuffledMergeCount());
    }
    /*private static void mergeSortOrderedList(List<City> cities){
        // Iterate through the cities list in reverse order
        for (int i = cities.size() - 1; i >= 0; i--) {
            // Get the city and its latitude
            City city = cities.get(i);
            double latitude = city.getLatitude();

            // Print the city name and latitude
            System.out.println(city.getName() + ": " + latitude);
        }
    }*/

    private static void performMergeSortWithLatitudeAndLongitude() {
        List<City> cities = readCitiesFromFile();

        // Perform merge sort on latitude and longitude pairs
        //MergeSort1.mergeSort1(cities, 1, 0, cities.size() - 1);

        MergeSort1.mergeSort2(cities); // Perform MergeSort based on latitude and longitude
        System.out.println("Sorted cities by Latitude and Longitude:");
        cities.forEach(System.out::println);
        System.out.println("The List is ordered based on calculation of the distance between the langitudes and latitudes using the Haversine formula.");
    }

    private static void performQuickSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV();
        System.out.println("\nPerforming Quick Sort...");
        System.out.println("\nRegular quick sort:");
        System.out.println("Number of quick sorts: " + result.getRegularQuickSortCount());
        System.out.println("\nShuffled quick sort:");
        System.out.println("Number of quick sorts: " + result.getShuffledQuickSortCount());
    }

    private static void performQuickSortWithLongitudeAndLatitude() {
        List<City> cities = readCitiesFromFile();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(cities); // Perform QuickSort based on longitude and latitude
        System.out.println("Sorted cities by Longitude and Latitude:");
        cities.forEach(System.out::println);
        System.out.println("The List is ordered based on calculation of the distance between the langitudes and latitudes using the Haversine formula.");
    }


    private static void viewAllCities() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV();
        System.out.println("All cities:");
        result.getCities().forEach(System.out::println);
    }

    private static List<City> readCitiesFromFile() {
        List<City> cities = new ArrayList<>();
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("src/Utils/worldcities.csv"))) {
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] cityData = line.split(splitBy);
                double latitude = Double.parseDouble(cityData[2].replaceAll("\"", ""));
                double longitude = Double.parseDouble(cityData[3].replaceAll("\"", ""));
                cities.add(new City(cityData[0], latitude, longitude));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}

/* -------her og nedover fungerer
package Utils;


import MergeSort.MergeSort1;
import MergeSort.MergeSort;
import QuickSort.QuickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWhich sorting algorithm do you want to use?");
            System.out.println("1. Merge Sort");
            System.out.println("2. Merge Sort Latitude and Longitude");
            System.out.println("3. Quick Sort");
            System.out.println("4. Quick Sort with Lang/Lat");
            System.out.println("5. View all Cities");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    performMergeSort();
                    break;
                case 2:
                    performMergeSortWithLatitudeAndLongitude();
                    //performSortWithLatitudeAndLongitude(2);
                    break;
                case 3:
                    performQuickSort();
                    break;
                case 4:
                    QuickSortLangLat();
                    //performSortWithLatitudeAndLongitude(1);
                    break;
                case 5:
                    viewAllCities();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void performMergeSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV();
        System.out.println("Performing Merge Sort...");
        System.out.println("Regular merge sort:");
        System.out.println("Number of merges: " + result.getRegularMergeCount());
        System.out.println("\nShuffled merge sort:");
        System.out.println("Number of Merge sorts: " + result.getShuffledMergeCount());
    }

    private static void performMergeSortWithLatitudeAndLongitude() {
        String line = "";
        String splitBy = ",";
        ArrayList<String[]> cities = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/hannaheilertsen/Dropbox/Mac/Documents/HK/2/V2024/AlgDAt/Exam/simplemaps_worldcities_basicv1.77/worldcities.csv"));

            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] city = line.split(splitBy);
                // Remove extra quotation marks from latitude and longitude
                String latitudeString = city[2].replaceAll("\"", "");
                String longitudeString = city[3].replaceAll("\"", "");
                // Ensure latitude and longitude are parsed as doubles
                double latitude = Double.parseDouble(latitudeString);
                double longitude = Double.parseDouble(longitudeString);
                // Store city name, latitude, and longitude as a string array
                String[] cityData = {city[0], latitudeString, longitudeString};
                cities.add(cityData);
            }

            // Perform merge sort on latitude and longitude pairs
            MergeSort1.mergeSort1(cities, 1, 0, cities.size() - 1);

            // Print city names, latitudes, and longitudes after sorting
            for (String[] cityData : cities) {
                System.out.println(Arrays.toString(cityData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle the case where latitude or longitude cannot be parsed as a double
            e.printStackTrace();
        }
    }

    private static void QuickSortLangLat() {
        List<City> QSCitiesLangLat = readCitiesFromFile();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(QSCitiesLangLat); // Bruker QuickSort for å sortere basert på breddegrad og lengdegrad
        System.out.println("Sorted cities:");
        QSCitiesLangLat.forEach(System.out::println);
    }

    private static List<City> readCitiesFromFile() {
        List<City> cities = new ArrayList<>();
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/hannaheilertsen/Dropbox/Mac/Documents/HK/2/V2024/AlgDAt/Exam/simplemaps_worldcities_basicv1.77/worldcities.csv"))) {
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] cityData = line.split(splitBy);
                double latitude = Double.parseDouble(cityData[2].replaceAll("\"", ""));
                double longitude = Double.parseDouble(cityData[3].replaceAll("\"", ""));
                cities.add(new City(cityData[0], latitude, longitude));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static void performQuickSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV();
        System.out.println("\nPerforming Quick Sort...");
        System.out.println("\nRegular quick sort:");
        System.out.println("Number of quick sorts: " + result.getRegularQuickSortCount());
        System.out.println("\nShuffled quick sort:");
        System.out.println("Number of quick sorts: " + result.getShuffledQuickSortCount());
    }

    private static void viewAllCities() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV();
        System.out.println("All cities:");
        result.getCities().forEach(System.out::println);
    }
    }
    ------------- Her og oppover fungerer*/

/*
    private static void performSortWithLatitudeAndLongitude(int algorithmChoice) {
        String line = "";
        String splitBy = ",";
        ArrayList<String[]> cities = new ArrayList<>();

        //List<String[]> cities = new ArrayList<>();

        int x;

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/hannaheilertsen/Dropbox/Mac/Documents/HK/2/V2024/AlgDAt/Exam/simplemaps_worldcities_basicv1.77/worldcities.csv"));

            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] city = line.split(splitBy);
                // Remove extra quotation marks from latitude and longitude
                String latitudeString = city[2].replaceAll("\"", "");
                String longitudeString = city[3].replaceAll("\"", "");
                // Ensure latitude and longitude are parsed as doubles
                double latitude = Double.parseDouble(latitudeString);
                double longitude = Double.parseDouble(longitudeString);
                // Store city name, latitude, and longitude as a string array
                String[] cityData = {city[0], latitudeString, longitudeString};
                cities.add(cityData);

            }

            switch (algorithmChoice){
                case 1:

                    QuickSort.quickSort(cities, 1, 0, cities.size() - 1);
                    List<City> cityObjects = new ArrayList<>();
                    for (String[] cityData : cities) {
                        City city = new City(cityData[0], Double.parseDouble(cityData[1]), Double.parseDouble(cityData[2]));
                        cityObjects.add(city);
                    }
                    QuickSort.quickSort(cityObjects, 0, cityObjects.size() - 1);
                    cities.clear();
                    for (City city : cityObjects) {
                        cities.add(new String[]{city.getName(), String.valueOf(city.getLatitude()), String.valueOf(city.getLongitude())});
                    }
                    break;
                case 2:
                    //MergeSort1.mergeSort1(cities, 1, 0, cities.size() - 1);
                    MergeSort1.mergeSort1(cities, 1, 0, cities.size() - 1);
                    break;
                default:
                    System.out.println("Invalid");
            }

            // Print city names, latitudes, and longitudes after sorting
            for (String[] cityData : cities) {
            //for (String[] cityData : cities) {
                System.out.println(Arrays.toString(cityData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle the case where latitude or longitude cannot be parsed as a double
            e.printStackTrace();
        }
    }*/