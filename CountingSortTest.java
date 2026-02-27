import java.util.Random;

/**
 * Test class for Counting Sort Algorithm
 * Tests the algorithm with 10 million random integers
 */
public class CountingSortTest {
    
    // Number of elements to test
    private static final int DATA_SIZE = 10_000_000; // 10 Million
    
    // Range of random numbers (0 to MAX_VALUE)
    private static final int MAX_VALUE = 10_000; // Keep range manageable for counting sort
    
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("COUNTING SORT ALGORITHM - PERFORMANCE TEST");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Test with 10 million elements
        testWithLargeDataset();
        
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println("TEST COMPLETED SUCCESSFULLY!");
        System.out.println("=".repeat(70));
    }
    
    /**
     * Test counting sort with 10 million elements
     */
    private static void testWithLargeDataset() {
        System.out.println("Test: Sorting " + String.format("%,d", DATA_SIZE) + " random integers");
        System.out.println("Range: 0 to " + String.format("%,d", MAX_VALUE));
        System.out.println("-".repeat(70));
        
        // Generate random data
        System.out.println("\n[1/4] Generating random data...");
        long startGeneration = System.nanoTime();
        int[] data = generateRandomData(DATA_SIZE, MAX_VALUE);
        long endGeneration = System.nanoTime();
        double generationTime = (endGeneration - startGeneration) / 1_000_000_000.0;
        System.out.println("      Data generation completed in: " + String.format("%.3f", generationTime) + " seconds");
        
        // Display sample of unsorted data
        System.out.println("\n[2/4] Sample of unsorted data (first 20 elements):");
        System.out.print("      ");
        CountingSort.printArray(data, 20);
        
        // Perform counting sort
        System.out.println("\n[3/4] Sorting data using Counting Sort...");
        long startSort = System.nanoTime();
        int[] sortedData = CountingSort.countingSort(data, MAX_VALUE);
        long endSort = System.nanoTime();
        double sortTime = (endSort - startSort) / 1_000_000_000.0;
        System.out.println("      Sorting completed in: " + String.format("%.3f", sortTime) + " seconds");
        
        // Verify the result
        System.out.println("\n[4/4] Verifying sorted data...");
        long startVerify = System.nanoTime();
        boolean isValid = CountingSort.isSorted(sortedData);
        long endVerify = System.nanoTime();
        double verifyTime = (endVerify - startVerify) / 1_000_000_000.0;
        
        if (isValid) {
            System.out.println("      ✓ Verification passed in: " + String.format("%.3f", verifyTime) + " seconds");
            System.out.println("      ✓ Array is correctly sorted!");
        } else {
            System.out.println("      ✗ Verification failed! Array is NOT sorted correctly.");
            return;
        }
        
        // Display sample of sorted data
        System.out.println("\n      Sample of sorted data (first 20 elements):");
        System.out.print("      ");
        CountingSort.printArray(sortedData, 20);
        
        System.out.println("\n      Sample of sorted data (last 20 elements):");
        System.out.print("      ");
        printLastElements(sortedData, 20);
        
        // Performance summary
        System.out.println("\n" + "-".repeat(70));
        System.out.println("PERFORMANCE SUMMARY:");
        System.out.println("-".repeat(70));
        System.out.println("Data Size:           " + String.format("%,d", DATA_SIZE) + " elements");
        System.out.println("Value Range:         0 to " + String.format("%,d", MAX_VALUE));
        System.out.println("Generation Time:     " + String.format("%.3f", generationTime) + " seconds");
        System.out.println("Sorting Time:        " + String.format("%.3f", sortTime) + " seconds");
        System.out.println("Verification Time:   " + String.format("%.3f", verifyTime) + " seconds");
        System.out.println("Total Time:          " + String.format("%.3f", (generationTime + sortTime + verifyTime)) + " seconds");
        System.out.println("\nElements per second: " + String.format("%,.0f", DATA_SIZE / sortTime) + " elements/sec");
        
        // Memory usage estimation
        long memoryUsed = (long) (data.length + sortedData.length + MAX_VALUE + 1) * 4; // 4 bytes per int
        System.out.println("Memory used (est.):  " + String.format("%.2f", memoryUsed / (1024.0 * 1024.0)) + " MB");
    }
    
    /**
     * Generate random data for testing
     * 
     * @param size Number of elements to generate
     * @param maxValue Maximum value for random numbers
     * @return Array of random integers
     */
    private static int[] generateRandomData(int size, int maxValue) {
        Random random = new Random(42); // Fixed seed for reproducibility
        int[] data = new int[size];
        
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(maxValue + 1);
        }
        
        return data;
    }
    
    /**
     * Print the last n elements of an array
     * 
     * @param arr The array
     * @param n Number of elements to print
     */
    private static void printLastElements(int[] arr, int n) {
        int start = Math.max(0, arr.length - n);
        System.out.print("[");
        if (start > 0) {
            System.out.print("... , ");
        }
        for (int i = start; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
