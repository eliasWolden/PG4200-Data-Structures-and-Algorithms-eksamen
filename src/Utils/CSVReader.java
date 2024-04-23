package Utils;

import MergeSort.MergeSort;
import QuickSort.QuickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVReader {
    private static final String FILE_PATH = "src/Utils/worldcities.csv";

    public CSVResult readAndSortCSV(int typeFromMain){
        List<City> cities = new ArrayList<>();
        int regularMergeSortCount = 0;
        int LatLongMergeSortCount = 0;
        int shuffledMergeCount = 0;
        int regularQuickSortCount = 0;
        int LatLongQuickSortCount = 0;
        int shuffledQuickSort = 0;

        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();



        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine(); // Skip the header line

            String line;
            while ((line = br.readLine()) != null) {
                String[] cityData = line.split(",");
                String latitudeString = cityData[2].replaceAll("^\"|\"$", ""); // Remove double quotes
                String longitudeString = cityData[3].replaceAll("^\"|\"$", ""); // Remove double quotes
                double latitude = Double.parseDouble(latitudeString);
                double longitude = Double.parseDouble(longitudeString);

                cities.add(new City(cityData[0], latitude, longitude));
            }
            switch (typeFromMain) {
                case 1 ->
                    // Sort with MergeSort
                        regularMergeSortCount = mergeSort.sort(cities);
                case 2 ->
                    //Sort with MergeSortLatLong
                        LatLongMergeSortCount = mergeSort.sortForLatLong(cities);
                case 3 ->
                    // Sort with QuickSort
                        regularQuickSortCount = quickSort.sort(cities);
                case 4 ->
                    // Sort with QuickSortLatLong
                        LatLongQuickSortCount = quickSort.sort(cities);
                default -> Collections.shuffle(cities);

                //idk hva dette er og hvorfor det er her
                // shuffledMergeCount = mergeSort.sort(new ArrayList<>(cities));
                // Collections.shuffle(cities);
                // shuffledQuickSort = quickSort.sort(new ArrayList<>(cities));
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return new CSVResult(cities, regularQuickSortCount, LatLongQuickSortCount, shuffledQuickSort, regularMergeSortCount, LatLongMergeSortCount, shuffledMergeCount);
    }
}
