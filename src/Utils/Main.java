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
        CSVResult result = csvReader.readAndSortCSV(1);
        System.out.println("Performing Merge Sort...");
        System.out.println("Regular merge sort:");
        result.getCities().forEach(System.out::println);
        System.out.println("Number of merges: " + result.getRegularMergeCount());
        System.out.println("\nShuffled merge sort:");
        System.out.println("Number of Merge sorts: " + result.getShuffledMergeCount());
    }

    private static void performMergeSortWithLatitudeAndLongitude() {
        List<City> cities = readCitiesFromFile();


        MergeSort1.mergeSort2(cities); // Perform MergeSort based on latitude and longitude
        System.out.println("Sorted cities by Latitude and Longitude:");
        cities.forEach(System.out::println);
        System.out.println("The List is ordered based on calculation of the distance between the langitudes and latitudes using the Haversine formula.");
    }

    private static void performQuickSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(3);
        System.out.println("\nPerforming Quick Sort...");
        System.out.println("\nRegular quick sort:");
        result.getCities().forEach(System.out::println);
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
        //temp type 1
        CSVResult result = csvReader.readAndSortCSV(1);
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