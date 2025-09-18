import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = ob.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            arr[i] = ob.nextInt();

        System.out.print("Enter target: ");
        int target = ob.nextInt();

        Solution obj = new Solution();
        int result[] = obj.twoSum(arr, target);

        if (result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No valid pair found!");
        }
    }
}
