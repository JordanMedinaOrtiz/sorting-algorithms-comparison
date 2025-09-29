<p align="left">
  <a href="README_ES.md" target="_blank">
    Ver README en Español
  </a>
</p>

# Sorting Algorithms Comparison

This project implements and compares four classic sorting algorithms: **InsertionSort**, **MergeSort**, **HeapSort** and **QuickSort**.

## Objective

Graphically analyze the performance of algorithms by measuring the number of comparisons performed on arrays of different sizes (1,000 to 100,000 elements).

## Project Files

### Implemented Algorithms:

- `InsertionSort.java` - Insertion sort algorithm (O(n²))
- `MergeSort.java` - Merge sort algorithm (O(n log n))
- `HeapSort.java` - Heap sort algorithm (O(n log n))
- `QuickSort.java` - Quick sort algorithm (O(n log n) average)

### Experiment Files:

- `AlgorithmExperiment.java` - Main program that runs all experiments
- `ResultsAnalysis.java` - Program to display formatted results analysis
- `algorithm_results.csv` - CSV file with generated data (for Excel)

## How to Execute

### 1. Compile all files:

```bash
javac *.java
```

### 2. Run the experiment:

```bash
java AlgorithmExperiment
```

### 3. View formatted results (optional):

```bash
java ResultsAnalysis
```

This command:

- Generates random arrays of sizes: 1,000, 10,000, 20,000, ..., up to 100,000
- Executes the 4 algorithms on each array (using identical copies)
- Counts the comparisons performed by each algorithm
- Saves results to `algorithm_results.csv`

## Create the Graph in Excel

1. Open the `algorithm_results.csv` file in Microsoft Excel
2. Select all data (including headers)
3. Insert → Charts → Line Chart
4. Configure:
   - **X-Axis**: Array size (1000, 10000, 20000, etc.)
   - **Y-Axis**: Number of comparisons
   - **Series**: One line for each algorithm

## Technical Features

- **Generic Functions**: All algorithms use generics (`<T extends Comparable<T>>`), allowing sorting of any comparable data type.
- **Comparison Counter**: Each algorithm has a `compare()` function that increments a global counter.
- **Random Arrays**: Random numbers between 0 and 9,999 are generated for each experiment.
- **Independent Copies**: Each algorithm works with an identical copy of the original array.

## Expected Results

The project should graphically demonstrate that:

1. **InsertionSort**: Quadratic growth (O(n²)) - Slowest for large arrays
2. **MergeSort**: Logarithmic-linear growth (O(n log n)) - Consistent and efficient
3. **HeapSort**: Logarithmic-linear growth (O(n log n)) - Good but more comparisons than MergeSort
4. **QuickSort**: Average logarithmic-linear growth (O(n log n)) - Very efficient in practice

## Important Notes

- Counters use `int` for the number of comparisons
- Experiments use random integer arrays
- Results may vary slightly between runs due to the random nature of the data
- **Note**: For very large arrays (100,000+ elements), InsertionSort may cause overflow in the counter

