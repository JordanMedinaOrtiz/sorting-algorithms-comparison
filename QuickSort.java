public class QuickSort {
  public static int counter = 0;

  public static <K extends Comparable<K>> boolean compare (K x, K y) {
    counter++;
    return x.compareTo(y) <= 0;
  }

  public static <T extends Comparable<T>> void quickSort(T[] A) {
    if (A.length > 1) {
      quickSort(A, 0, A.length - 1);
    }
  }

  private static <T extends Comparable<T>> void quickSort(T[] A, int low, int high) {
    if (low < high) {
      // pi is partitioning index, A[pi] is now at right place
      int pi = partition(A, low, high);

      // Recursively sort elements before and after partition
      quickSort(A, low, pi - 1);
      quickSort(A, pi + 1, high);
    }
  }

  // This function takes last element as pivot, places the pivot element
  // at its correct position in sorted array, and places all smaller
  // (smaller than pivot) to left of pivot and all greater elements to right of pivot
  private static <T extends Comparable<T>> int partition(T[] A, int low, int high) {
    T pivot = A[high]; // pivot
    int i = (low - 1); // index of smaller element

    for (int j = low; j < high; j++) {
      // If current element is smaller than or equal to pivot
      if (compare(A[j], pivot)) {
        i++;

        // swap A[i] and A[j]
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
    }

    // swap A[i+1] and A[high] (or pivot)
    T temp = A[i + 1];
    A[i + 1] = A[high];
    A[high] = temp;

    return i + 1;
  }

  public static void main(String args[]) {
    Integer A[] = {10, 7, 8, 9, 1, 5};
    System.out.println("Original array:");
    for (Integer x : A)
        System.out.print(x + " ");
    System.out.println();

    counter = 0;
    quickSort(A);

    System.out.println("Sorted array:");
    for (Integer x : A)
        System.out.print(x + " ");
    System.out.println();
    System.out.println("Number of comparisons: " + counter);
  }
}