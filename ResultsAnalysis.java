import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResultsAnalysis {
    
    public static void main(String[] args) {
        System.out.println("=== RESULTS ANALYSIS ===");
        System.out.println("Reading data from CSV file...\n");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("algorithm_results.csv"));
            String line;
            boolean firstLine = true;
            
            System.out.printf("%-8s | %-12s | %-12s | %-12s | %-12s%n", 
                            "Size", "InsertionSort", "MergeSort", "HeapSort", "QuickSort");
            System.out.println("---------|--------------|--------------|--------------|-------------");
            
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip headers
                }
                
                String[] data = line.split(",");
                int size = Integer.parseInt(data[0]);
                long insertion = Long.parseLong(data[1]);
                long merge = Long.parseLong(data[2]);
                long heap = Long.parseLong(data[3]);
                long quick = Long.parseLong(data[4]);
                
                System.out.printf("%-8d | %-12s | %-12s | %-12s | %-12s%n", 
                                size, 
                                formatNumber(insertion),
                                formatNumber(merge),
                                formatNumber(heap),
                                formatNumber(quick));
            }
            reader.close();
            
            System.out.println("\n=== OBSERVATIONS ===");
            System.out.println("1. InsertionSort (O(n²)): Clearly the worst performance for large arrays");
            System.out.println("2. MergeSort (O(n log n)): Consistent and efficient behavior");
            System.out.println("3. HeapSort (O(n log n)): Good but more comparisons than MergeSort");
            System.out.println("4. QuickSort (O(n log n) average): Very efficient in practice");
            System.out.println("\nOpen 'algorithm_results.csv' in Excel to create your graph!");
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Function to format large numbers with commas
    private static String formatNumber(long number) {
        return String.format("%,d", number);
    }
}