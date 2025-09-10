
---

# 🏃 Hop Value Problem

## 📌 Problem Statement

You are standing at the first index of an array.
Each element in the array tells you the **maximum steps you can jump forward**.

Your task is to determine:

1. The **minimum number of hops** needed to reach the end of the array.
2. If it is **not possible** to reach the end, return `-1`.

---

## ✅ Example 1

**Input:**

```
arr = [2, 3, 1, 1, 4]
```

**Output:**

```
2
```

**Explanation:**

* Jump from index `0 → 1` (using 2 steps).
* Jump from index `1 → 4` (end).
  Total hops = **2**

---

## ✅ Example 2

**Input:**

```
arr = [3, 2, 1, 0, 4]
```

**Output:**

```
-1
```

**Explanation:**
You will always get stuck at index `3`, hence it’s **impossible** to reach the last index.

---

## 🧑‍💻 Java Solution

```java
import java.util.*;

class HopValue {
    public static int minHops(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int jumps = 1;   // At least one jump
        int maxReach = arr[0];
        int steps = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println("Minimum hops: " + minHops(arr));
    }
}
```

---

## 📊 Complexity Analysis

* **Time Complexity:** `O(n)` → we scan the array once.
* **Space Complexity:** `O(1)` → only a few extra variables used.

---

## 🎯 Key Learnings

* Greedy approach is applied.
* Keep track of **maximum reachable index** and **steps left**.
* Increase hop count only when no steps remain.

---

✨ This problem is commonly asked in interviews by **Amazon, Microsoft, and Infosys** to test Greedy Algorithm understanding.

---

