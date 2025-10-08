---

```markdown
# 📘 Allocate Minimum Number of Pages

## 🧩 Problem Statement

You are given an array `arr[]` of integers where each element represents the number of pages in a book.  
There are `k` students, and the task is to allocate all books to these students such that:

- Each student gets **at least one book**.
- Each book is allocated to **exactly one student**.
- The **maximum number of pages assigned to a student** is **minimized**.

Your goal is to find the **minimum possible value of the maximum pages** assigned to a student after the allocation.

If the number of students `k` is greater than the number of books `n`, return `-1`.

---

## 🧠 Example

### Input:
```

arr = [12, 34, 67, 90]
k = 2

```

### Output:
```

113

````

### Explanation:
Allocation of books could be done as follows:
- Student 1 → [12, 34, 67] = 113 pages  
- Student 2 → [90] = 90 pages  

The maximum number of pages assigned = **113**.  
This is the minimum possible among all allocations.

---

## 🔍 Approach

This problem can be efficiently solved using **Binary Search** over the possible range of answers.

### 🔸 Step 1: Define Search Space
- The **minimum** possible answer = `max(arr)` (since one book must go to someone).  
- The **maximum** possible answer = `sum(arr)` (if one student gets all books).

### 🔸 Step 2: Binary Search
Perform binary search between `low = max(arr)` and `high = sum(arr)`:
- For each `mid` value, check if it is possible to allocate books so that **no student has more than `mid` pages**.

### 🔸 Step 3: Validation Function
The helper function `isValid()` checks if a given maximum (`mid`) is a feasible allocation:
- Traverse through the array and allocate pages sequentially to students.
- When the current student’s pages exceed `mid`, assign books to the next student.
- If the number of students required exceeds `k`, it’s not possible.

---

## 🧮 Time Complexity

| Operation | Complexity |
|------------|-------------|
| Binary Search | O(log(sum(arr))) |
| Validation Check | O(n) |
| **Total** | O(n × log(sum(arr))) |

---

## 💻 Java Code

```java
class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;

        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int start = max, end = sum, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, k, n, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int[] arr, int k, int n, int maxAllowed) {
        int students = 1, pages = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllowed) return false;
            if (pages + arr[i] <= maxAllowed) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];
            }
        }
        return students <= k;
    }
}
````

---

## 🧾 Example Walkthrough

**Input:**

```
arr = [10, 20, 30, 40]
k = 2
```

**Process:**

* Search space: 40 → 100
* Mid = 70 → valid (can allocate)
* Mid = 55 → invalid
* Final answer = **60**

**Output:**

```
60
```

---

## ✅ Key Takeaways

* Classic **Binary Search on Answer** problem.
* Commonly asked in **interviews** (Amazon, Microsoft, Google).
* Focuses on minimizing the **maximum workload** distribution.

---

```

---

