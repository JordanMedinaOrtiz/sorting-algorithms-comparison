public class HeapSort {
  public static int counter = 0;

  public static <K extends Comparable<K>> boolean compare (K x, K y) {
    counter++;
    return x.compareTo(y) > 0;
  }

  public static <T extends Comparable<T>> void heapSort(T[] A) {
    int n = A.length;

    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(A, n, i);

    for (int i = n - 1; i > 0; i--) {
      T temp = A[0];
      A[0] = A[i];
      A[i] = temp;

      heapify(A, i, 0);
    }
  }

  private static <T extends Comparable<T>> void heapify(T[] A, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && compare(A[left], A[largest]))
      largest = left;

    if (right < n && compare(A[right], A[largest]))
      largest = right;

    if (largest != i) {
      T swap = A[i];
      A[i] = A[largest];
      A[largest] = swap;

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
