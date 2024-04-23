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

    private void mergeSort(List<City> cities, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(cities, left, mid);
            mergeSort(cities, mid + 1, right);
            merge(cities, left, mid, right);
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
}