
---

# Sum Zero Array

## 📌 Problem Statement

Given an integer `n`, return an array containing `n` unique integers such that the sum of all elements is **0**.

### Example 1

**Input:**

```
n = 5
```

**Output:**

```
[1, -1, 2, -2, 0]
```

### Example 2

**Input:**

```
n = 4
```

**Output:**

```
[1, -1, 2, -2]
```

---

## 💡 Approach

* Use a **two-pointer like technique** by filling numbers in pairs `(i, -i)`.
* This guarantees that every positive number has its negative counterpart, so the sum cancels out to **0**.
* If `n` is **odd**, the remaining number will be `0`, which does not affect the sum.

---

## 🚀 Solution (Java)

```java
import java.util.*;

class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        for (int i = 1; i < n; i += 2) {
            arr[i - 1] = i;
            arr[i] = -i;
        }
        // if n is odd, last element remains 0
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
```

---

## 🔍 Complexity Analysis

* **Time Complexity:** `O(n)` → loop runs `n/2` times
* **Space Complexity:** `O(n)` → output array of size `n`

---

## ✨ Key Takeaways

* Clever use of **pairs of positives and negatives** ensures sum = 0.
* Handles both **even** and **odd** values of `n`.
* Simple and efficient solution.

---

