

```markdown
# 🧭 Smallest Substring to Reach Same Coordinates

## 📜 Problem Statement

You are given a string consisting of directions:

- `R` → move **Right** (+1 in x)  
- `L` → move **Left** (−1 in x)  
- `U` → move **Up** (+1 in y)  
- `D` → move **Down** (−1 in y)

You start at position **(0, 0)** on a 2D plane.  
After executing all moves in the given string, you end up at a final coordinate **(x, y)**.

Your task is to **find the smallest substring** of the given string such that performing only that substring’s moves also results in ending at the **same final coordinate (x, y)**.

---

## 🧩 Example

### Example 1
**Input:**  
```

s = "RULDR"

```

| Step | Move | Position (x, y) |
|------|-------|----------------|
| Start | - | (0, 0) |
| 1 | R | (1, 0) |
| 2 | U | (1, 1) |
| 3 | L | (0, 1) |
| 4 | D | (0, 0) |
| 5 | R | (1, 0) |

✅ Final coordinate = **(1, 0)**  
The substring `"R"` alone also ends at (1, 0).

**Output:**  
```

R

```

---

### Example 2
**Input:**  
```

s = "RLUD"

```

Final coordinate = (0, 0)

Possible substrings reaching (0,0):
- `"RL"` → (0, 0)
- `"UD"` → (0, 0)

✅ Both work, smallest length = 2.

**Output:**  
```

RL

````
(or `UD`)

---

## ⚙️ Approach

1. Use a coordinate system with `(x, y)` starting at (0, 0).
2. Traverse the string and simulate the moves.
3. Keep track of all visited coordinates using a **HashMap** where:  
   - Key → `"x,y"` (the coordinate)
   - Value → index where it last appeared
4. Maintain the final coordinate `(x_final, y_final)` after all moves.
5. During traversal, check for the smallest substring that also reaches `(x_final, y_final)` by tracking offset positions.

---

## 🧠 Intuition

- The full string leads to `(x_final, y_final)`.  
- If we ever reach a point `(curX, curY)` such that the difference `(curX - x_final, curY - y_final)` was seen before, then the substring between those indices will lead to the same `(x_final, y_final)` overall.

This is similar to the prefix-sum technique used in array subarray problems.

---

## 💻 Java Implementation

```java
import java.util.*;

public class SmallestSubstringToReachXY {
    public static void main(String[] args) {
        String s = "RLUDRL";
        findSmallestSubstring(s);
    }

    static void findSmallestSubstring(String s) {
        int n = s.length();
        int x = 0, y = 0;

        // Step 1: Find final position
        for (char c : s.toCharArray()) {
            if (c == 'R') x++;
            else if (c == 'L') x--;
            else if (c == 'U') y++;
            else if (c == 'D') y--;
        }

        // Step 2: Find smallest substring that ends at same (x, y)
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1); // starting point before index 0

        int curX = 0, curY = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1, end = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'R') curX++;
            else if (c == 'L') curX--;
            else if (c == 'U') curY++;
            else if (c == 'D') curY--;

            // Reaching the same final destination point (x, y)
            if (curX == x && curY == y) {
                if (i + 1 < minLen) {
                    minLen = i + 1;
                    start = 0;
                    end = i;
                }
            }

            // Check if (curX - x, curY - y) seen before
            String key = (curX - x) + "," + (curY - y);
            if (map.containsKey(key)) {
                int j = map.get(key);
                if (i - j < minLen) {
                    minLen = i - j;
                    start = j + 1;
                    end = i;
                }
            }

            map.put(curX + "," + curY, i);
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println("No substring found");
        } else {
            System.out.println("Smallest Substring: " + s.substring(start, end + 1));
            System.out.println("Length: " + minLen);
        }
    }
}
````

---

## 🧾 Output Example

```
Input: RLUDRL
Smallest Substring: RL
Length: 2
```

---

## 🕒 Time & Space Complexity

| Complexity | Description                                    |
| ---------- | ---------------------------------------------- |
| **Time**   | O(n) — one pass through string                 |
| **Space**  | O(n) — for HashMap storing visited coordinates |

---

## 🧩 Summary

* Track each move as coordinate change.
* Use a map to store previous positions.
* Find the shortest substring leading to the same final destination.

---

**Author:** Utkarsh Gupta ✨
**Language Used:** Java ☕
**Topic Tags:** HashMap, Prefix Sum, Strings, Coordinates

```

---

