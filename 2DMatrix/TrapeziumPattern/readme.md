
---

# ⭐ Trapezium Pattern Problem

## 📌 Problem Statement

Anirudh is attending an astronomy lecture. His professor gives a challenge:

Write a program to print a **trapezium pattern** using stars (`*`) and dots (`.`).

---

## 🔹 Example

### Example 1

**Input:**

```
N = 3
```

**Output:**

```
**.**
*...*
.....
*...*
**.**
```

---

### Example 2

**Input:**

```
N = 4
```

**Output:**

```
***.***
**...**
*.....*
.......
*.....*
**...**
***.***
```

---

## 🚀 Approach

1. The pattern has **2N - 1 rows**.
2. First half (`1..N`):

   * Stars on both sides decrease each row.
   * Dots in the middle increase each row.
3. Middle row (`N`):

   * All dots.
4. Second half (`N+1..2N-1`):

   * Symmetric to the first half.

---

## 🧑‍💻 Java Solution

```java
public class TrapeziumPattern {
    public static void printTrapezium(int N) {
        // Upper half
        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int j = 1; j <= (2 * (N - i) + 1); j++) System.out.print(".");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }

        // Lower half (mirror of upper)
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            for (int j = 1; j <= (2 * (N - i) + 1); j++) System.out.print(".");
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTrapezium(3);
        System.out.println();
        printTrapezium(4);
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(N^2)` (nested loops for stars and dots).
* **Space Complexity:** `O(1)` (only uses constants).

---

✅ The code generates a **symmetric trapezium pattern** with stars on both sides and dots in the middle.

---

