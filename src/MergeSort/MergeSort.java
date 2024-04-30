package MergeSort;

import Utils.City;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    // Time Complexity: O(n log n) for all cases (average, worst, and best)
    // Space Complexity: O(n) - requires additional space for merging
    private int mergeCount = 0;

    public int sort(List<City> cities) {
        mergeCount = 0;
        mergeSort(cities, 0, cities.size() - 1);
        return mergeCount;
    }
    public int sortForLatLong(List<City> cities) {
        int mergeCounter = 0;
        mergeSortForLatLong(cities, 0, cities.size() - 1);
        return mergeCounter;
    }

    private void mergeSort(List<City> cities, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(cities, left, mid);
            mergeSort(cities, mid + 1, right);
            merge(cities, left, mid, right);
        }
    }
    private void mergeSortForLatLong(List<City> cities, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortForLatLong(cities, left, mid);
            mergeSortForLatLong(cities, mid + 1, right);
            mergeForLatLong(cities, left, mid, right);
        }
    }

    private void merge(List<City> cities, int left, int mid, int right) {
        List<City> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            // Compare latitude values of cities
            if (cities.get(i).getLatitude() <= cities.get(j).getLatitude()) {
                temp.add(cities.get(i++));
            } else {
                temp.add(cities.get(j++));
            }
            mergeCount++;
        }

        while (i <= mid) {
            temp.add(cities.get(i++));
            mergeCount++;
        }

        while (j <= right) {
            temp.add(cities.get(j++));
            mergeCount++;
        }

        for (int k = left; k <= right; k++) {
            cities.set(k, temp.get(k - left));
        }
    }
    public static void mergeForLatLong(List<City> cities, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        City[] L = new City[n1];
        City[] R = new City[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = cities.get(left + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = cities.get(mid + 1 + j);
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (compareCoordinates(L[i], R[j]) <= 0) {
                cities.set(k, L[i]);
                i++;
            } else {
                cities.set(k, R[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            cities.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            cities.set(k, R[j]);
            j++;
            k++;
        }
    }

    private static int compareCoordinates(City city1, City city2) {
        return CoordinateComparator.compareCoordinates(
                Double.toString(city1.getLatitude()),
                Double.toString(city1.getLongitude()),
                Double.toString(city2.getLatitude()),
                Double.toString(city2.getLongitude())
        );
    }
}