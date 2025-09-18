
---

# Word Formation from String

## Problem Statement

Given two strings `str` and `word`, determine how many times you can form the `word` using the characters available in `str`.
Each character in `str` can be used only as many times as it appears.

---

## Examples

### Example 1:

**Input:**

```
str = "This is a test string"
word = "tsit"
```

**Output:**

```
2
```

**Explanation:**

* In `str`: `t=4, s=4, i=3`
* In `word`: `t=2, s=1, i=1`
* Ratios → `t: 4/2=2`, `s: 4/1=4`, `i: 3/1=3`
* Minimum ratio = 2 → we can form `"tsit"` 2 times.

---

### Example 2:

**Input:**

```
str = "Here is HashedIn Technologies"
word = "neurons"
```

**Output:**

```
0
```

**Explanation:**
`str` does not contain the character `'u'`. Hence `"neurons"` cannot be formed even once.

---

## Approach

1. Count the frequency of each character in `str`.
2. Count the frequency of each character in `word`.
3. For each character in `word`, calculate:

   ```
   available_count_in_str / required_count_in_word
   ```

   (integer division).
4. The **minimum ratio** across all characters is the answer.
5. If any character from `word` is missing in `str`, return `0`.

---

## Java Implementation

```java
import java.util.*;

public class WordFormation {
    public static int countWords(String str, String word) {
        // Count frequency of str
        Map<Character, Integer> strFreq = new HashMap<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) { // ignore spaces/non-letters
                strFreq.put(c, strFreq.getOrDefault(c, 0) + 1);
            }
        }

        // Count frequency of word
        Map<Character, Integer> wordFreq = new HashMap<>();
        for (char c : word.toLowerCase().toCharArray()) {
            wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
        }

        // Find minimum ratio
        int min = Integer.MAX_VALUE;
        for (char c : wordFreq.keySet()) {
            if (!strFreq.containsKey(c)) {
                return 0; // missing character
            }
            min = Math.min(min, strFreq.get(c) / wordFreq.get(c));
        }

        return min;
    }

    public static void main(String[] args) {
        String str1 = "This is a test string";
        String word1 = "tsit";
        System.out.println(countWords(str1, word1)); // 2

        String str2 = "Here is HashedIn Technologies";
        String word2 = "neurons";
        System.out.println(countWords(str2, word2)); // 0
    }
}
```

---

## Complexity Analysis

* **Time Complexity:** `O(n + m)`

  * `n` = length of `str`
  * `m` = length of `word`
* **Space Complexity:** `O(1)` (since character set is bounded).


## Java Implementation

```java
public class Main {
    public static int countWords(String str, String word) {
        int[] strFreq = new int[26];
        int[] wordFreq = new int[26];

        // Count str frequencies
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                strFreq[c - 'a']++;
            }
        }

        // Count word frequencies
        for (char c : word.toLowerCase().toCharArray()) {
            wordFreq[c - 'a']++;
        }

        // Find limiting factor
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] > 0) {
                if (strFreq[i] == 0) return 0;
                min = Math.min(min, strFreq[i] / wordFreq[i]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(countWords("This is a test string", "tsit")); // 2
        System.out.println(countWords("Here is HashedIn Technologies", "neurons")); // 0
    }
}

```

---

