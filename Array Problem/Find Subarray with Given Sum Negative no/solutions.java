import java.util.*;

class SubarrayGivenSum {
    public static void findSubarray(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: Subarray starts from index 0
            if (prefixSum == target) {
                System.out.println("Subarray found from 0 to " + i);
                return;
            }

            // Case 2: Subarray found in between
            if (map.containsKey(prefixSum - target)) {
                int start = map.get(prefixSum - target) + 1;
                System.out.println("Subarray found from " + start + " to " + i);
                return;
            }

            // store prefixSum if not already present
            map.putIfAbsent(prefixSum, i);
        }

        System.out.println("No subarray with given sum");
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int target = -10;

        findSubarray(arr, target);
    }
}
