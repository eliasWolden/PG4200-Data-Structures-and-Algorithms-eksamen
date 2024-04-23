package QuickSort;

import java.util.List;

import MergeSort.CoordinateComparator;
import Utils.City;

public class QuickSort {
    // Time Complexity: O(n log n) average case, O(n^2) worst case
    // Space Complexity: O(log n) to O(n) depending on the implementation
    // (O(log n) for the recursive stack, O(n) for auxiliary space)
    private int swapCount = 0;

    public int sort(List<City> cities) {
        swapCount = 0;
        quickSort(cities, 0, cities.size() - 1);
        return swapCount;
    }

    private void quickSort(List<City> cities, int low, int high) {
        if (low < high) {
            int pi = partition(cities, low, high);
            quickSort(cities, low, pi - 1);
            quickSort(cities, pi + 1, high);
        }
    }

    private int partition(List<City> cities, int low, int high) {
        // Choosing the pivot as the city at the high index
        City pivotCity = cities.get(high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Comparing cities using custom compare method
            if (compare(cities.get(j), pivotCity) <= 0) {
                i++;
                swap(cities, i, j);
            }
        }
        swap(cities, i + 1, high);
        return i + 1;
    }


    private int compare(City city1, City city2) {
        // Using CoordinateComparator to compare cities based on latitude and longitude
        return CoordinateComparator.compareCoordinates(
                Double.toString(city1.getLatitude()),
                Double.toString(city1.getLongitude()),
                Double.toString(city2.getLatitude()),
                Double.toString(city2.getLongitude())
        );
    }


    private void swap(List<City> cities, int i, int j) {
        City temp = cities.get(i);
        cities.set(i, cities.get(j));
        cities.set(j, temp);
        swapCount++;
    }
}