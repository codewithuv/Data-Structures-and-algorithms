
---

# Find Subarray of Given Sum (Positive Numbers Only)

## 📌 Problem Statement

Given an array of **positive integers** and a target sum `S`, find a **continuous subarray** in the array whose elements add up to exactly `S`.

If such a subarray exists, return its starting and ending indices. If no such subarray exists, return `-1`.

---

## 🧠 Approach: **Sliding Window (Two Pointers)**

Since the array contains **only positive numbers**, we can efficiently use the **sliding window technique**.

### 🔹 Key Idea

* Maintain a window (subarray) using **two pointers (`start` and `end`)**.
* Keep track of the **current sum** of elements inside the window.
* If `current_sum` is **less than target**, expand the window by moving `end` forward.
* If `current_sum` is **greater than target**, shrink the window by moving `start` forward.
* If `current_sum == target`, we found the subarray.

---

### 🔹 Step-by-Step Example

**Input:**

```text
arr = [1, 4, 20, 3, 10, 5], S = 33
```

1. Start with `start = 0`, `end = 0`, `current_sum = 0`.
2. Add elements while `current_sum < S`.

   * [1, 4, 20, 3, 10] → sum = 38 (> 33).
3. Shrink from left until sum ≤ target.

   * Removing 1, sum = 37 → still > 33.
   * Removing 4, sum = 33 ✅.
4. Subarray found: `[20, 3, 10]`.

---

## ⏱️ Time Complexity

* **O(n)** → Each element is added and removed at most once.
* Efficient compared to brute force `O(n²)`.

---

## ✅ Code Implementation (Java)

```java
public class SubarraySumPositive {
    static void subarraySum(int[] arr, int target) {
        int start = 0, currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink window if sum > target
            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if sum matches target
            if (currentSum == target) {
                System.out.println("Subarray found from index " + start + " to " + end);
                return;
            }
        }

        System.out.println("No subarray found");
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;
        subarraySum(arr, target);
    }
}
```

---

## 🎯 Sample Output

```
Subarray found from index 2 to 4
```

(Which corresponds to `[20, 3, 10]`)

---

## 📌 Notes

* Works **only for positive numbers**.
* For arrays containing **negative numbers**, we need a **prefix sum + HashMap** approach.

---
