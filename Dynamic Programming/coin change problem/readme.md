
---

# 🪙 Coin Change Problem

## 📌 Problem Statement

You are given an integer array `coins` representing coin denominations and an integer `amount` representing a total amount of money. Return the **fewest number of coins** that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

This is a **classic Dynamic Programming problem** that is frequently asked in coding interviews.

---

## 📊 Example

**Input:**

```java
coins = [1, 2, 5], amount = 11
```

**Output:**

```
3
```

**Explanation:**
11 can be made with 5 + 5 + 1 = 3 coins.

---

## 🚀 Approach

We use **Dynamic Programming (DP)** to solve this problem:

1. Create a `dp[]` array where `dp[i]` stores the minimum number of coins needed to make amount `i`.
2. Initialize `dp[0] = 0` (base case).
3. For each amount from `1` to `amount`, check each coin denomination and update the `dp` array.
4. If no valid combination is found, return `-1`.

⏱ **Time Complexity:** `O(amount * n)` where `n` is the number of coin types
💾 **Space Complexity:** `O(amount)`

---

## 📝 Code

```java
import java.util.*;

class Solution {
    public static void main(String args[]) {
        int coins[] = {1, 2, 5}; // sample input
        int amount = 11;         // sample input
        Solution obj = new Solution();
        System.out.print(obj.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c <= i && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
```

---

## ✅ Sample Run

```
Input: coins = [1, 2, 5], amount = 11  
Output: 3
```

---

## 📂 Topics Covered

* Dynamic Programming
* Array Manipulation
* Optimization Problems

---

## 💡 Key Takeaway

The **Coin Change Problem** teaches how to break down problems into **subproblems** and use **DP to optimize** solutions instead of brute force recursion.

---

