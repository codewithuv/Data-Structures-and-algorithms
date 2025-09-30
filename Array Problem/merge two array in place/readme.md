---

# 📌 Merge Two Sorted Arrays Without Extra Space

## 📖 Overview

This project demonstrates an **in-place algorithm** to merge two sorted arrays without using extra space.
It uses the **Gap Method** (inspired by Shell Sort) to efficiently merge arrays while maintaining sorted order.

* **Input:** Two sorted arrays `arr1[]` and `arr2[]`
* **Output:** The arrays rearranged such that combined elements are sorted across both arrays

✅ Time Complexity: **O((n+m) log(n+m))**
✅ Space Complexity: **O(1)**

---

## 🚀 Problem Statement

You are given two sorted arrays, `arr1` of size `n` and `arr2` of size `m`.
Merge them so that:

* The first `n` elements (smallest ones) are stored in `arr1`
* The next `m` elements (largest ones) are stored in `arr2`

**Constraint:** No extra space should be used (except a few variables).

---

## 💡 Approach (Gap Method)

1. Calculate an initial `gap = ceil((n+m)/2)`.
2. Compare elements that are `gap` apart across `arr1` and `arr2`.
3. Swap them if out of order.
4. Reduce the gap as `gap = ceil(gap/2)` and repeat until `gap == 0`.

This ensures all elements are shifted towards their correct positions in each iteration.

---

## 📝 Example

**Input:**

```
arr1 = [1, 4, 7, 8, 10]  
arr2 = [2, 3, 9]
```

**Output:**

```
arr1 = [1, 2, 3, 4, 7]  
arr2 = [8, 9, 10]
```

---

## 💻 Code Implementation (Java)

```java
import java.util.*;

class MergeSortedArrays {
    public static void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n + m + 1) / 2; // initial gap (ceil)

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < n + m) {
                int a = (i < n) ? arr1[i] : arr2[i - n];
                int b = (j < n) ? arr1[j] : arr2[j - n];

                if (a > b) {
                    if (i < n && j < n) { // both in arr1
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    } else if (i < n && j >= n) { // i in arr1, j in arr2
                        int temp = arr1[i];
                        arr1[i] = arr2[j - n];
                        arr2[j - n] = temp;
                    } else { // both in arr2
                        int temp = arr2[i - n];
                        arr2[i - n] = arr2[j - n];
                        arr2[j - n] = temp;
                    }
                }
                i++;
                j++;
            }

            if (gap == 1) gap = 0;
            else gap = (gap + 1) / 2; // ceil(gap/2)
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};

        merge(arr1, arr2);

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}
```

---

## 🛠️ How to Run

1. Save the code in `MergeSortedArrays.java`.
2. Compile:

   ```bash
   javac MergeSortedArrays.java
   ```
3. Run:

   ```bash
   java MergeSortedArrays
   ```

---

## 📚 References

* [Dutch National Flag & Gap Method](https://www.geeksforgeeks.org/merge-two-sorted-arrays-without-extra-space/)
* Shell Sort concept (gap reduction idea)

---

