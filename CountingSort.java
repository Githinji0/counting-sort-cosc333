/**
 * Counting Sort Algorithm Implementation
 * 
 * Counting Sort is a non-comparison based sorting algorithm that works by
 * counting the number of objects having distinct key values.
 * 
 * Time Complexity: O(n + k) where n is the number of elements and k is the range
 * Space Complexity: O(k) for the counting array
 * 
 * Best Use Case: When the range of input data (k) is not significantly greater than
 * the number of elements to be sorted (n).
 */
public class CountingSort {
    
    /**
     * Sorts an array using counting sort algorithm
     * 
     * @param arr The input array to be sorted
     * @param maxValue The maximum value in the array (for optimization)
     * @return The sorted array
     */
    public static int[] countingSort(int[] arr, int maxValue) {
        // Create counting array to store count of each element
        int[] count = new int[maxValue + 1];
        int[] output = new int[arr.length];
        
        // Store count of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        
        // Change count[i] so that count[i] contains actual
        // position of this element in output array
        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        // Iterate from right to left to maintain stability
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        
        return output;
    }
    
    /**
     * Overloaded method that automatically finds the maximum value
     * 
     * @param arr The input array to be sorted
     * @return The sorted array
     */
    public static int[] countingSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        
        // Find the maximum value in the array
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        
        return countingSort(arr, maxValue);
    }
    
    /**
     * Utility method to check if an array is sorted
     * 
     * @param arr The array to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Utility method to print array elements (for small arrays)
     * 
     * @param arr The array to print
     * @param limit Maximum number of elements to print
     */
    public static void printArray(int[] arr, int limit) {
        int printLimit = Math.min(arr.length, limit);
        System.out.print("[");
        for (int i = 0; i < printLimit; i++) {
            System.out.print(arr[i]);
            if (i < printLimit - 1) {
                System.out.print(", ");
            }
        }
        if (arr.length > limit) {
            System.out.print(", ... (" + (arr.length - limit) + " more elements)");
        }
        System.out.println("]");
    }
}
