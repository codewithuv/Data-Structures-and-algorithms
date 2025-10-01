# Find Subarray with Given Sum (works with negative numbers)

## Problem statement

Given an integer array `arr[]` (may contain **positive and negative** numbers) and a target `sum`, find a contiguous subarray whose elements add up to the given `sum`.

* Return the indices (start and end) of one such subarray (if any), or
* Optionally, return **all** subarrays that satisfy the condition.

This README explains the **prefix-sum + hashmap** approach (works when negatives are present), gives a detailed dry-run, shows Java implementations (first-match and all-matches), complexity, edge cases and how to run.

---

## Key idea / intuition (why prefix sum works)

Let `prefix[i]` denote the sum of elements `arr[0]` through `arr[i]` (inclusive).
If a subarray `(l..r)` sums to `target`, then:

```
prefix[r] - prefix[l-1] == target
=> prefix[r] - target == prefix[l-1]
```

So when we are at index `r` with `prefix[r]`, we only need to check whether `(prefix[r] - target)` has occurred earlier as a prefix sum. If yes, the subarray from index `(previousIndex + 1)` to `r` is a valid answer.

We maintain a map of seen prefix sums -> index (or list of indices for all occurrences). This gives an **O(n)** time solution.

---

## Algorithm (step-by-step for first-match)

1. Initialize `prefixSum = 0`.
2. Initialize a `HashMap<Long,Integer>` to store earliest occurrence of each prefix sum. Optionally put `(0 -> -1)` if you want to detect subarrays starting at index 0.
3. Iterate `i` from `0` to `n-1`:

   * `prefixSum += arr[i]`
   * If `prefixSum == target` → subarray `0..i` is a solution (or detected via map with `prefixSum - target == 0` if map had `0 -> -1`).
   * Else check if `(prefixSum - target)` exists in map:

     * If yes, let `startIndex = map.get(prefixSum - target) + 1`, the subarray `startIndex..i` sums to target → return it.
   * If `prefixSum` is not already in map, store `map.putIfAbsent(prefixSum, i)` (store earliest index).
4. If loop finishes with no match → no such subarray exists.

**Notes:**

* Use `long` for prefix sums to avoid integer overflow.
* `putIfAbsent` keeps the earliest index; this is helpful if you want the leftmost (earliest) subarray.

---

## Dry run (detailed)

Example: `arr = [10, 2, -2, -20, 10]`, `target = -10`

We’ll track `i`, `arr[i]`, `prefixSum`, and `map`:

* start: `map = {}`, optionally `map.put(0, -1)` to handle prefixSum==target from index 0
* i=0: prefixSum = 10

  * prefixSum - target = 10 - (-10) = 20 → not in map
  * store map[10] = 0 → `map = {0:-1, 10:0}`
* i=1: prefixSum = 12

  * 12 - (-10) = 22 → not in map
  * store map[12] = 1 → `map = {0:-1, 10:0, 12:1}`
* i=2: prefixSum = 10  (12 + -2)

  * 10 - (-10) = 20 → not in map
  * map already contains 10 at index 0; we keep earliest (do not overwrite)
* i=3: prefixSum = -10 (10 + -20)

  * prefixSum == target → subarray 0..3 sums to -10 → found!
    Result: subarray indices `(0, 3)`. (Matches earlier example.)

---

## Correctness sketch

For any `r`, if `(prefix[r] - target)` is a recorded prefix sum value at index `l-1`, then `prefix[r] - prefix[l-1] == target` ⇒ subarray `(l..r)` sums to `target`. We check this for every `r`, so if any valid subarray exists, we will find one.

---

## Complexity

* **Time Complexity:** `O(n)` — single pass over array; hashmap operations are O(1) average.
* **Space Complexity:** `O(n)` — for storing prefix sums in the hashmap (worst-case distinct prefix sums).

---

## Edge cases & tips

* Empty array → no subarray (unless target is 0 and you define empty subarray as valid).
* If target is 0, a prefix sum repeating value indicates a zero-sum subarray.
* Use `long` for prefix sums in Java to prevent overflow with large integers.
* If you need **all** subarrays, store each prefix sum’s **list** of indices in the map and for every occurrence of `(prefix - target)` append all possible subarray ranges.
* To return the earliest (leftmost) match, store the earliest index for every prefix sum (`putIfAbsent`).

---

## Java implementations

### 1) Find first subarray that sums to target (prints indices)

```java
import java.util.*;

public class SubarrayGivenSum {
    // finds and prints the first subarray (leftmost) that sums to target
    public static boolean findFirstSubarray(int[] arr, int target) {
        Map<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;
        map.put(0L, -1); // handle subarray starting at index 0

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            long need = prefixSum - target;
            if (map.containsKey(need)) {
                int start = map.get(need) + 1;
                System.out.printf("Subarray found from %d to %d%n", start, i);
                return true;
            }

            // store earliest occurrence of this prefixSum
            map.putIfAbsent(prefixSum, i);
        }

        System.out.println("No subarray with given sum");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int target = -10;
        findFirstSubarray(arr, target);
    }
}
```

### 2) Find **all** subarrays that sum to target (returns list of index pairs)

```java
import java.util.*;

public class SubarrayGivenSumAll {
    // returns list of int[]{start, end} pairs for all subarrays summing to target
    public static List<int[]> findAllSubarrays(int[] arr, int target) {
        Map<Long, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        long prefixSum = 0;

        // prefix sum 0 occurs at index -1 (to handle subarray from 0..i)
        map.put(0L, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            long need = prefixSum - target;

            if (map.containsKey(need)) {
                for (int startIndex : map.get(need)) {
                    result.add(new int[] { startIndex + 1, i });
                }
            }

            // add current prefixSum occurrence
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10, 0, -10};
        int target = -10;
        List<int[]> subs = findAllSubarrays(arr, target);

        if (subs.isEmpty()) {
            System.out.println("No subarray with given sum");
        } else {
            for (int[] p : subs) {
                System.out.printf("Subarray from %d to %d%n", p[0], p[1]);
            }
        }
    }
}
```

---

## Python quick reference (first-match)

```python
def find_first_subarray(arr, target):
    pref = 0
    seen = {0: -1}  # prefix sum -> earliest index
    for i, val in enumerate(arr):
        pref += val
        need = pref - target
        if need in seen:
            return (seen[need] + 1, i)
        if pref not in seen:
            seen[pref] = i
    return None

# Example
arr = [10,2,-2,-20,10]
print(find_first_subarray(arr, -10))  # prints (0, 3)
```

---

## How to run (Java)

1. Save the desired class (e.g., `SubarrayGivenSum.java` or `SubarrayGivenSumAll.java`).
2. Compile:

   ```bash
   javac SubarrayGivenSum.java
   ```
3. Run:

   ```bash
   java SubarrayGivenSum
   ```

---

## Variations & interview talking points

* If array contains **only non-negative numbers**, explain the **sliding window** (two-pointer) solution (O(n), O(1)).
* For negatives, explain why sliding window fails and prefix-sum + hashmap is required.
* Discuss memory vs. speed trade-offs (to find just one subarray you can stop early).
* Mention integer overflow concerns and use of `long` in Java for prefix sums.

---

