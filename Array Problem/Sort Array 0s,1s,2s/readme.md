---

# Sort an Array of 0s, 1s, and 2s in O(n)

## 📌 Problem Statement

Given an array consisting only of `0s`, `1s`, and `2s`, sort the array in **O(n)** time and **O(1)** space without using any built-in sort function.

### Example 1:

**Input:**

```
arr = [0, 1, 2, 0, 1, 2]
```

**Output:**

```
[0, 0, 1, 1, 2, 2]
```

### Example 2:

**Input:**

```
arr = [2, 0, 1]
```

**Output:**

```
[0, 1, 2]
```

---

## 🚀 Approach – Dutch National Flag Algorithm

We use three pointers (`low`, `mid`, `high`) to sort the array in one pass:

1. **low** → keeps track of the boundary where `0s` should be placed.
2. **mid** → traverses the array.
3. **high** → keeps track of the boundary where `2s` should be placed.

### Steps:

* If `arr[mid] == 0`: Swap with `arr[low]` and increment both `low` and `mid`.
* If `arr[mid] == 1`: Just move `mid` forward.
* If `arr[mid] == 2`: Swap with `arr[high]` and decrement `high` (do not increment `mid` immediately).

---

## 💻 Code Implementation (Java)

```java
public class Sort012 {
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** O(n) (single traversal of the array).
* **Space Complexity:** O(1) (in-place sorting, no extra space).

---

## ✅ Key Takeaways

* This is a classic **Dutch National Flag problem**.
* Efficient solution in **linear time** with **constant space**.
* No extra data structure required.

---

