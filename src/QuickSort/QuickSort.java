package QuickSort;

import java.util.List;

import MergeSort.CoordinateComparator;
import Utils.City;

public class QuickSort {
    private int swapCount = 0;

    public int sort(List<City> cities, boolean compareBoth) {
        swapCount = 0;
        quickSort(cities, 0, cities.size() - 1, compareBoth);
        return swapCount;
    }

    private void quickSort(List<City> cities, int low, int high, boolean compareBoth) {
        if (low < high) {
            int pi = partition(cities, low, high, compareBoth);
            quickSort(cities, low, pi - 1, compareBoth);
            quickSort(cities, pi + 1, high, compareBoth);
        }
    }

    private int partition(List<City> cities, int low, int high, boolean compareBoth) {
        City pivotCity = cities.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(cities.get(j), pivotCity, compareBoth) <= 0) {
                i++;
                swap(cities, i, j);
            }
        }
        swap(cities, i + 1, high);
        return i + 1;
    }

    private int compare(City city1, City city2, boolean compareBoth) {
        if (compareBoth) {
            return CoordinateComparator.compareCoordinates(
                    Double.toString(city1.getLatitude()),
                    Double.toString(city1.getLongitude()),
                    Double.toString(city2.getLatitude()),
                    Double.toString(city2.getLongitude())
            );
        } else {
            return Double.compare(city1.getLatitude(), city2.getLatitude());
        }
    }

    private void swap(List<City> cities, int i, int j) {
        City temp = cities.get(i);
        cities.set(i, cities.get(j));
        cities.set(j, temp);
        swapCount++;
    }
}