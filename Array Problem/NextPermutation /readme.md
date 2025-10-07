# Next Permutation — README

## Problem Overview

Given a number **A** represented as a string, find the **smallest number** (in value) that is **strictly greater than A** and can be formed by reordering the digits of A. If no such number exists (i.e., A is the largest possible permutation of its digits), return `-1`.

This problem is commonly called **Next Permutation** and is a fundamental algorithmic routine used in combinatorics and interview questions. It runs in linear time and constant extra space (assuming the string is mutable or transformable to an array).

---

## Input / Output

* **Input:** A single numeric string `A` (no leading zeros in `A` as per typical problem constraints).
* **Output:** A string representing the smallest number greater than `A` that uses exactly the same digits, or `"-1"` if no such number exists.

---

## Examples

| Input    | Output   | Explanation                                   |
| -------- | -------- | --------------------------------------------- |
| `218765` | `251678` | Next lexicographic permutation of digits.     |
| `1234`   | `1243`   | Smallest change to make it greater.           |
| `4321`   | `-1`     | Digits in descending order — already maximum. |
| `115`    | `151`    | Reordering with duplicates handled.           |
| `9`      | `-1`     | Single digit — no larger permutation.         |

---

## Intuition

Permutations of the digits sorted lexicographically form an ordered sequence. The *next* permutation after a given arrangement is the smallest permutation that is larger than the current one. To obtain it with minimal change:

1. Find the rightmost position where a digit is **smaller** than a digit to its right (call this index `i`). If there is no such position, digits are non-increasing from left to right and the current permutation is the maximum — return `-1`.
2. From the right end, find the smallest digit `>` `A[i]` (call its index `j`). Because the suffix is non-increasing, the first digit from the right that is greater than `A[i]` is the correct one.
3. Swap `A[i]` and `A[j]`. Now the prefix up to `i` is minimally larger.
4. Reverse the suffix (the part after index `i`) to make it the smallest possible arrangement of those digits.

This produces the next lexicographical (and numeric) permutation.

---

## Algorithm (Step-by-step)

Given a char array (or string) `arr` of length `n`:

1. Let `i = n-2`. While `i >= 0` and `arr[i] >= arr[i+1]`, decrement `i`.

   * If `i < 0`, return `-1` (entire string is non-increasing).
2. Let `j = n-1`. While `arr[j] <= arr[i]`, decrement `j`.
3. Swap `arr[i]` and `arr[j]`.
4. Reverse `arr[i+1 .. n-1]`.
5. Return `new String(arr)`.

**Why this works:** the suffix `arr[i+1..n-1]` is in non-increasing order. By swapping `arr[i]` with the smallest element greater than it in that suffix, we increase the prefix minimally. Reversing the suffix yields the smallest possible completion after that increase.

---

## Complexity

* **Time complexity:** `O(n)` — each step (scan, second scan, swap, reverse) visits each element at most a constant number of times.
* **Space complexity:** `O(1)` extra (in-place on a mutable char array). Converting to/from a char array may require `O(n)` temporary storage depending on language, but no additional asymptotic memory is needed beyond the output.

---

## Edge Cases & Notes

* If `A` has length 0 or 1, return `-1`.
* If digits are already in non-increasing order (e.g., `654321`), return `-1`.
* Duplicates are handled gracefully by the algorithm — the check `arr[i] < arr[i+1]` and later `arr[j] > arr[i]` work correctly even with repeated digits.
* The problem statement usually assumes `A` has no leading zeros. If intermediate steps produce leading zeros (for example, input contains zeros), keep the string representation as-is — the algorithm still produces the next permutation of digits.

---

## Implementations

### Java (InterviewBit / LeetCode style)

```java
public class NextPermutation {
    public static String nextGreater(String A) {
        char[] arr = A.toCharArray();
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return "-1";

        int j = n - 1;
        while (arr[j] <= arr[i]) j--;

        // swap
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        // reverse suffix
        reverse(arr, i + 1, n - 1);

        return new String(arr);
    }

    private static void reverse(char[] a, int l, int r) {
        while (l < r) {
            char t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreater("218765")); // 251678
        System.out.println(nextGreater("4321"));   // -1
        System.out.println(nextGreater("115"));    // 151
    }
}
```

### Python

```python
def next_greater(A: str) -> str:
    arr = list(A)
    n = len(arr)
    i = n - 2
    while i >= 0 and arr[i] >= arr[i+1]:
        i -= 1
    if i < 0:
        return "-1"

    j = n - 1
    while arr[j] <= arr[i]:
        j -= 1

    arr[i], arr[j] = arr[j], arr[i]
    arr[i+1:] = reversed(arr[i+1:])
    return ''.join(arr)

# quick tests
print(next_greater("218765"))  # 251678
print(next_greater("4321"))    # -1
print(next_greater("115"))     # 151
```

---

## Test Cases (suggested)

1. Single digit: `"7"` → `-1`
2. Already max: `"54321"` → `-1`
3. Simple increment: `"123"` → `132`
4. With duplicates: `"115"` → `151`
5. Long with trailing descending suffix: `"129465"` → compute and verify
6. Very long input (stress test): random digits of length `10^5` (ensure algorithm stays O(n`) and memory usage is acceptable).

---

## Common Pitfalls

* Trying to convert the entire number to an integer (or BigInteger) — not feasible for very long strings.
* Forgetting to reverse the suffix after swapping — this results in a larger-than-necessary permutation.
* Using the wrong comparison direction when scanning for pivot or successor.

---

## Further Reading

* Standard library `next_permutation` in C++ (`<algorithm>`) implements the same logic.
* Related problems: generate all permutations in lexicographic order, previous permutation, kth permutation.

---

## License

