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
        int shuffledMergeCount = 0;
        int regularQuickSortCount = 0;
        int shuffledQuickSort = 0;

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
            case 1:
                // Sort with MergeSort
                MergeSort mergeSort = new MergeSort();
                regularMergeSortCount = mergeSort.sort(cities);
                break;
            case 3:
                // Sort with QuickSort
                QuickSort quickSort = new QuickSort();
                regularQuickSortCount = quickSort.sort(cities);
                break;
            default:
                Collections.shuffle(cities);
                //idk hva dette er og hvorfor det er her
                // shuffledMergeCount = mergeSort.sort(new ArrayList<>(cities));
                // Collections.shuffle(cities);
                // shuffledQuickSort = quickSort.sort(new ArrayList<>(cities));
                break;
        }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return new CSVResult(cities, regularQuickSortCount, shuffledQuickSort, regularMergeSortCount, shuffledMergeCount);
    }
}
