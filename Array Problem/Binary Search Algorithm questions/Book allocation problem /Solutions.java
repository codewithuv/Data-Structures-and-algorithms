class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;

        int sum = 0, max = 0;
        for (int pages : arr) {
            sum += pages;
            max = Math.max(max, pages);
        }

        int start = max, end = sum, ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, n, k, mid)) {
                ans = mid;
                end = mid - 1; // try smaller maximum
            } else {
                start = mid + 1; // increase pages limit
            }
        }
        return ans;
    }

    public boolean isValid(int[] arr, int n, int k, int maxAllowed) {
        int studentCount = 1;
        int pages = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllowed)
                return false; // cannot allocate this book

            if (pages + arr[i] <= maxAllowed) {
                pages += arr[i];
            } else {
                studentCount++;
                pages = arr[i];
            }
        }
        return studentCount <= k;
    }
}
