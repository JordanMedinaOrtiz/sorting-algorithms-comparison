public class InsertionSort {
    public static int counter = 0;

    public static <K extends Comparable<K>> boolean compare (K x, K y) {
        counter++;
        return x.compareTo(y) > 0;
    }

    public static <T extends Comparable<T>> void insertionSort(T A[]) {
        for (int j = 1; j < A.length; j++) {
            T key = A[j];
            int i = j - 1;
            while (i >= 0 && compare(A[i], key)) {
                A[i + 1] = A[i];
                i--;
            }
            A[i+ 1] = key;
        }
    }

    public static void main(String args[]) {
        Integer A[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        for (Integer x : A)
            System.out.print(x + " ");
        System.out.println();
        
        counter = 0;
        insertionSort(A);
        
        System.out.println("Sorted array:");
        for (Integer x : A)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("Number of comparisons: " + counter);
    }
}