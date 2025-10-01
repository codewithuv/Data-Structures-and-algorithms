class SubarrayGivenSumPositive {
    public static void findSubarray(int[] arr, int target) {
        int n = arr.length;
        int start = 0, currSum = 0;

        for (int end = 0; end < n; end++) {
            currSum += arr[end];

            // Shrink the window if sum is greater than target
            while (currSum > target && start <= end) {
                currSum -= arr[start];
                start++;
            }

            // Check if we found the subarray
            if (currSum == target) {
                System.out.println("Subarray found from " + start + " to " + end);
                return;
            }
        }

        System.out.println("No subarray with given sum");
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;

        findSubarray(arr, target);
    }
}
