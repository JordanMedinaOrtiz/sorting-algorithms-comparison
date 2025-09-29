import java.util.Arrays;

public class MergeSort {
    public static int counter = 0;

    public static <K extends Comparable<K>> boolean compare (K x, K y) {
        counter++;
        return x.compareTo(y) <= 0;
    }

    private static <T extends Comparable<T>> void merge(T[] A, int left, int middle, int right) {
        T[] leftArray = Arrays.copyOfRange(A, left, middle + 1);
        T[] rightArray = Arrays.copyOfRange(A, middle + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (compare(leftArray[i], rightArray[j])) {
                A[k] = leftArray[i];
                i++;
            } else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            A[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] A) {
        if (A.length > 1) {
            mergeSort(A, 0, A.length - 1);
        }
    }

    private static <T extends Comparable<T>> void mergeSort(T[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
            merge(A, left, middle, right);
        }
    }

    public static void main(String[] args) {
        Integer[] A = {10, 8, 4, 2, 1, 5, 6, 3, 7, 9};
        System.out.println("Original array:");
        for (Integer x : A)
            System.out.print(x + " ");
        System.out.println();

        counter = 0;
        mergeSort(A);

        System.out.println("Sorted array:");
        for (Integer x : A)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("Number of comparisons: " + counter);
    }


}
