package MergeSort;

import Utils.City;

import java.util.List;

public class MergeSort1 {

    // Initiates the merge sort by recursively calling the merge1 method
    // Initiates the merge sort by recursively calling the merge1 method
    public static void mergeSort2(List<City> arr) {
        mergeSort1(arr, 0, arr.size() - 1);
    }
    public static void mergeSort1(List<City> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort1(arr, left, mid);
            mergeSort1(arr, mid + 1, right);
            merge1(arr, left, mid, right);
        }
    }

    // Performs the actual merge operation
    public static void merge1(List<City> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to store subarrays to be merged
        City[] L = new City[n1];
        City[] R = new City[n2];

        // Copy the data to the temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr.get(left + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr.get(mid + 1 + j);
        }

        // Merge the temporary arrays back into the main array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            // Compare values based on latitude and longitude
            if (compareCoordinates(L[i], R[j]) <= 0) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Add remaining elements from L if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        // Add remaining elements from R if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }

    // Comparison method based on latitude and longitude using CoordinateComparator
    private static int compareCoordinates(City city1, City city2) {
        // Using CoordinateComparator to compare cities based on latitude and longitude
        return CoordinateComparator.compareCoordinates(
                Double.toString(city1.getLatitude()),
                Double.toString(city1.getLongitude()),
                Double.toString(city2.getLatitude()),
                Double.toString(city2.getLongitude())
        );
    }

    // Comparison method based on latitude and longitude
   /* private static int compareCoordinates(City city1, City city2) {
        // Compare latitude first
        if (city1.getLatitude() < city2.getLatitude()) {
            return -1;
        } else if (city1.getLatitude() > city2.getLatitude()) {
            return 1;
        } else {
            // If latitude is the same, compare longitude
            if (city1.getLongitude() < city2.getLongitude()) {
                return -1;
            } else if (city1.getLongitude() > city2.getLongitude()) {
                return 1;
            } else {
                return 0;
            }
        }
    }*/
}


/*------ start på fungerende kode
package MergeSort;


import java.util.ArrayList;

public class MergeSort1 {

    // Initiates the merge sort by recursively calling the merge1 method
    public static void mergeSort1(ArrayList<String[]> arr, int col, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort1(arr, col, left, mid);
            mergeSort1(arr, col, mid + 1, right);
            merge1(arr, col, left, mid, right);
        }
    }
    // Performs the actual merge operation
    public static void merge1(ArrayList<String[]> arr, int col, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to store subarrays to be merged
        String[][] L = new String[n1][];
        String[][] R = new String[n2][];

        // Copy the data to the temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr.get(left + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr.get(mid + 1 + j);
        }

        // Merge the temporary arrays back into the main array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            // Compare values based on the comparison function (CoordinateComparator.compareCoordinates)
            if (CoordinateComparator.compareCoordinates(L[i][1], L[i][2], R[j][1], R[j][2]) <= 0) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Add remaining elements from L if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        // Add remaining elements from R if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }
    ------- Slutt på fungerende kode*/

    // Performs the actual merge operation
   /* public static void merge1(ArrayList<String[]> arr, int col, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to store subarrays to be merged
        String[][] L = new String[n1][];
        String[][] R = new String[n2][];

        // Copy the data to the temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr.get(left + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr.get(mid + 1 + j);
        }

        // Merge the temporary arrays back into the main array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            // Compare values based on the comparison function (not specified here)
            // The comparison function must be implemented separately
            if (CoordinateComparator.compareCoordinates(L[i][1], L[i][2], R[j][1], R[j][2]) <= 0) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Add remaining elements from L if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        // Add remaining elements from R if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }
}*/
