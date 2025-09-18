import java.util.*;

class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        for (int i = 1; i < n; i += 2) {
            arr[i - 1] = i;
            arr[i] = -i;
        }
        // if n is odd, last element will be 0 (default value in int[])
        return arr;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution sol = new Solution();
        int[] result = sol.sumZero(n);

        // Print array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
