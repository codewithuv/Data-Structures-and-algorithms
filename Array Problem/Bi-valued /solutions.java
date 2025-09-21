import java.util.*;

public class BiValuedArray {
    public static int solution(int[] A, int N) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < N; right++) {
            freq.put(A[right], freq.getOrDefault(A[right], 0) + 1);

            // Shrink window if more than 2 distinct numbers
            while (freq.size() > 2) {
                freq.put(A[left], freq.get(A[left]) - 1);
                if (freq.get(A[left]) == 0) {
                    freq.remove(A[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] A1 = {4, 2, 2, 4, 2};
        System.out.println(solution(A1, A1.length)); // Output: 5

        int[] A2 = {1, 2, 3, 2};
        System.out.println(solution(A2, A2.length)); // Output: 3

        int[] A3 = {0, 5, 4, 4, 5, 12};
        System.out.println(solution(A3, A3.length)); // Output: 4

        int[] A4 = {4, 4};
        System.out.println(solution(A4, A4.length)); // Output: 2
    }
}
