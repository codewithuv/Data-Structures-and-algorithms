public class NextPermutation {
    public static String nextGreater(String A) {
    char[] arr = A.toCharArray();   
    int n = arr.length;
    int i = n - 2;  
        //find first decreasing element from right
        while (i >= 0 && arr[i] >= arr[i + 1])
         i--;
        // return  if i reaches the starting meaning in DESc  order
        if (i < 0) 
        return "-1";

        //find the element just greater than arr[i]
        int j = n - 1;
        while (arr[j] <= arr[i]) 
        j--;


            // swap
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;


    // reverse suffix
    reverse(arr, i + 1, n - 1);
    return new String(arr);
}


private static void reverse(char[] a, int l, int r) {
        while (l < r) {
        char t = a[l]; a[l] = a[r]; a[r] = t;
        l++; r--;
    }
}


public static void main(String[] args) {
    System.out.println(nextGreater("218765")); // 251678
    System.out.println(nextGreater("4321")); // -1
    System.out.println(nextGreater("115")); // 151
    }
}