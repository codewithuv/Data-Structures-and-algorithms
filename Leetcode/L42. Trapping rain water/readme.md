
---

# 🏞️ Trapping Rain Water (LeetCode #42)

## 📌 Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

### Example 1

**Input:**

```
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

**Output:**

```
6
```

### Example 2

**Input:**

```
height = [4,2,0,3,2,5]
```

**Output:**

```
9
```

---

## ⚡ Approach

We solve this problem using the **prefix-max and suffix-max technique**.

1. **Left Array** → For each index, store the maximum height from the left.
2. **Right Array** → For each index, store the maximum height from the right.
3. **Water Level** → At every index, the trapped water is:

   ```
   min(left[i], right[i]) - height[i]
   ```
4. Add up all trapped water to get the final result.

---

## 📝 Code (Java)

```java
import java.util.*;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
       
        // Left max for each index
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // Right max for each index
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        // Calculate trapped water
        int waterlevel = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            waterlevel += min - height[i];
        }

        return waterlevel;
    }

    public static void main(String args[]) {
        Solution ob = new Solution();
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(ob.trap(arr)); // Output: 6
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)` (Two passes to build left and right arrays, one pass for result)
* **Space Complexity:** `O(n)` (Two extra arrays for left and right maximums)

---

## 🚀 Optimizations

The above solution uses extra space. It can be optimized to **O(1) space** using the **two-pointer approach** while maintaining `O(n)` time.

---

## ✅ Key Takeaways

* Classic **two-pass dynamic programming** problem.
* Understanding prefix/suffix max arrays is essential.
* Can be optimized to **two pointers + O(1) space** for better memory efficiency.

---


