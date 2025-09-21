
---

# 🟢 Bi-Valued Array Problem

## 📌 Problem Statement

We call an array **bi-valued** if it contains at most **two different numbers**.
The task is to find the **length of the longest contiguous subarray (slice)** in a given array `A` that is bi-valued.

---

### 🔹 Example

1. Input: `A = [4, 2, 2, 4, 2]`
   Output: `5`
   (The whole array is bi-valued: only {2, 4}).

2. Input: `A = [1, 2, 3, 2]`
   Output: `3`
   (Longest bi-valued slice is `[2, 3, 2]`).

3. Input: `A = [0, 5, 4, 4, 5, 12]`
   Output: `4`
   (Longest slice is `[5, 4, 4, 5]`).

4. Input: `A = [4, 4]`
   Output: `2`.

---

## 🚀 Approach

A naive approach (using frequency counts of the entire array) doesn’t work because the slice must be **continuous**.
So, we use a **Sliding Window + HashMap** approach:

1. Use a window `[left..right]` that always contains **at most 2 distinct numbers**.
2. Expand `right` pointer to include more elements.
3. If the window exceeds 2 distinct numbers, shrink it from the `left`.
4. Track the **maximum valid window length** at each step.

This ensures we only count **contiguous bi-valued subarrays**.

---

## 🧑‍💻 Java Solution

```java
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
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(N)` – Each element is added and removed from the map at most once.
* **Space Complexity:** `O(2) = O(1)` – Since the map stores at most 2 keys.

---

✅ This ensures the company always finds the **longest bi-valued slice** in linear time.

---

