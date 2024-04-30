package Utils;


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
            System.out.println("5. Perform Merge Sort with data randomized");
            System.out.println("6. Perform Quick Sort with data randomized");
            System.out.println("7. View all Cities");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> performMergeSort();
                case 2 -> performMergeSortWithLatitudeAndLongitude();
                case 3 -> performQuickSort();
                case 4 -> performQuickSortWithLongitudeAndLatitude();
                case 5 -> performRandomizedMergeSort();
                case 6 -> performRandomizedQuickSort();
                case 7 -> viewAllCities();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void performMergeSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(1);
        System.out.println("Performing Merge Sort...");
        System.out.println("Regular merge sort:");
        result.getCities().forEach(city -> System.out.println("City: " + city.getName() + ", Latitude: " + city.getLatitude()));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Number of Merge sorts: " + result.getRegularMergeCount());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

    }

    private static void performMergeSortWithLatitudeAndLongitude() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(2);
        System.out.println("Sorted cities by Latitude and Longitude:");
        result.getCities().forEach(city -> System.out.println("City: " + city.getName() + ", Latitude: " + city.getLatitude() + ", Longitude: " + city.getLongitude()));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("The List is ordered based on calculation of the distance between the longitudes and latitudes using the Haversine formula.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

    }

    private static void performQuickSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(3);
        System.out.println("Performing Quick Sort...");
        System.out.println("Regular Quick sort:");
        result.getCities().forEach(city -> System.out.println("City: " + city.getName() + ", Latitude: " + city.getLatitude()));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Number of quick sorts: " + result.getRegularQuickSortCount());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

    }

    private static void performQuickSortWithLongitudeAndLatitude() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(4);
        System.out.println("Sorted cities by Longitude and Latitude:");
        result.getCities().forEach(city -> System.out.println("City: " + city.getName() + ", Latitude: " + city.getLatitude() + ", Longitude: " + city.getLongitude()));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("The List is ordered based on calculation of the distance between the longitudes and latitudes using the Haversine formula.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }
    private static void performRandomizedMergeSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(5);
        System.out.println("Performing Merge Sort with data randomized...");
        System.out.println("----------------------------------------------");
        System.out.println("Number of merge sorts when randomized: " + result.getShuffledMergeCount());
        CSVResult result2 = csvReader.readAndSortCSV(1);
        System.out.println("----------------------------------------------");
        System.out.println("Number of merge sorts: " + result2.getRegularMergeCount());
        System.out.println("----------------------------------------------");
    }
    private static void performRandomizedQuickSort() {
        CSVReader csvReader = new CSVReader();
        CSVResult result = csvReader.readAndSortCSV(6);
        System.out.println("Performing Quick Sort with data randomized...");
        System.out.println("----------------------------------------------");
        System.out.println("Number of quick sorts when randomized: " + result.getShuffledQuickSortCount());
        System.out.println("----------------------------------------------");
        CSVResult result2 = csvReader.readAndSortCSV(3);
        System.out.println("Number of quick sorts: " + result2.getRegularQuickSortCount());
        System.out.println("----------------------------------------------");

    }


    private static void viewAllCities() {
        CSVReader csvReader = new CSVReader();
        //temp type 1
        CSVResult result = csvReader.readAndSortCSV(0);
        System.out.println("All cities:");
        result.getCities().forEach(city -> System.out.println("City: " + city.getName()));
    }

}