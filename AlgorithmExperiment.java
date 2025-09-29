import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class AlgorithmExperiment {
    
    // Generate random integer array
    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // random numbers between 0 and 9999
        }
        return array;
    }

    // Create a copy of the array for each algorithm
    public static Integer[] copyArray(Integer[] original) {
        return Arrays.copyOf(original, original.length);
    }

    // Execute experiment for a specific size
    public static void runExperiment(int size, FileWriter writer) throws IOException {
        System.out.println("Running experiment for array size: " + size);
        
        // Generate original array
        Integer[] originalArray = generateRandomArray(size);
        
        // Create copies for each algorithm
        Integer[] insertionArray = copyArray(originalArray);
        Integer[] mergeArray = copyArray(originalArray);
        Integer[] heapArray = copyArray(originalArray);
        Integer[] quickArray = copyArray(originalArray);
        
        // Test InsertionSort
        InsertionSort.counter = 0;
        InsertionSort.insertionSort(insertionArray);
        int insertionComparisons = InsertionSort.counter;
        
        // Test MergeSort
        MergeSort.counter = 0;
        MergeSort.mergeSort(mergeArray);
        int mergeComparisons = MergeSort.counter;
        
        // Test HeapSort
        HeapSort.counter = 0;
        HeapSort.heapSort(heapArray);
        int heapComparisons = HeapSort.counter;
        
        // Test QuickSort
        QuickSort.counter = 0;
        QuickSort.quickSort(quickArray);
        int quickComparisons = QuickSort.counter;
        
        // Write results to CSV file
        writer.write(size + "," + insertionComparisons + "," + mergeComparisons + 
                    "," + heapComparisons + "," + quickComparisons + "\n");
        
        // Show results in console
        System.out.println("Size: " + size);
        System.out.println("  InsertionSort: " + insertionComparisons + " comparisons");
        System.out.println("  MergeSort: " + mergeComparisons + " comparisons");
        System.out.println("  HeapSort: " + heapComparisons + " comparisons");
        System.out.println("  QuickSort: " + quickComparisons + " comparisons");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== SORTING ALGORITHMS EXPERIMENT ===");
        System.out.println("Comparing InsertionSort, MergeSort, HeapSort and QuickSort");
        System.out.println("Generating random arrays of different sizes...\n");
        
        try {
            // Create CSV file for results
            FileWriter writer = new FileWriter("algorithm_results.csv");
            
            // Write CSV headers
            writer.write("Size,InsertionSort,MergeSort,HeapSort,QuickSort\n");
            
            // Array sizes to test: 1000, 10000, 20000, 30000, ..., 100000
            int[] sizes = {1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
            
            // Run experiments for each size
            for (int size : sizes) {
                runExperiment(size, writer);
            }
            
            writer.close();
            System.out.println("Experiments completed!");
            System.out.println("Results have been saved to 'algorithm_results.csv'");
            System.out.println("You can open this file in Excel to create your graph.");
            
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}