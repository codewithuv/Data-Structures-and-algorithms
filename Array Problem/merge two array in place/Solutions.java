import java.util.*;

class MergeSortedArrays {
    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n + m + 1) / 2; // initial gap (ceil)

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < n + m) {
                int a = (i < n) ? arr1[i] : arr2[i - n];
                int b = (j < n) ? arr1[j] : arr2[j - n];

                if (a > b) {
                    if (i < n && j < n) { // both in arr1
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    } else if (i < n && j >= n) { // i in arr1, j in arr2
                        int temp = arr1[i];
                        arr1[i] = arr2[j - n];
                        arr2[j - n] = temp;
                    } else { // both in arr2
                        int temp = arr2[i - n];
                        arr2[i - n] = arr2[j - n];
                        arr2[j - n] = temp;
                    }
                }
                i++;
                j++;
            }

            if (gap == 1) gap = 0;
            else gap = (gap + 1) / 2; // ceil(gap/2)
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};

        merge(arr1, arr2);

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}
