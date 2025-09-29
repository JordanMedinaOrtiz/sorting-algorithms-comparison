public class HeapSort {
  public static int counter = 0;

  public static <K extends Comparable<K>> boolean compare (K x, K y) {
    counter++;
    return x.compareTo(y) > 0;
  }

  public static <T extends Comparable<T>> void heapSort(T[] A) {
    int n = A.length;

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(A, n, i);

    // Extract elements from heap one by one
    for (int i = n - 1; i > 0; i--) {
      // Move current root to end
      T temp = A[0];
      A[0] = A[i];
      A[i] = temp;

      // Call heapify on the reduced heap
      heapify(A, i, 0);
    }
  }

  // To heapify a subtree rooted with node i which is an index in A[]
  // n is size of heap
  private static <T extends Comparable<T>> void heapify(T[] A, int n, int i) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left = 2*i + 1
    int right = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (left < n && compare(A[left], A[largest]))
      largest = left;

    // If right child is larger than largest so far
    if (right < n && compare(A[right], A[largest]))
      largest = right;

    // If largest is not root
    if (largest != i) {
      T swap = A[i];
      A[i] = A[largest];
      A[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(A, n, largest);
    }
  }

  public static void main(String args[]) {
    Integer A[] = {12, 11, 13, 5, 6, 7};
    System.out.println("Original array:");
    for (Integer x : A)
        System.out.print(x + " ");
    System.out.println();

    counter = 0;
    heapSort(A);

    System.out.println("Sorted array:");
    for (Integer x : A)
        System.out.print(x + " ");
    System.out.println();
    System.out.println("Number of comparisons: " + counter);
  }
}