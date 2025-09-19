
---

# Number of Islands

## Problem Statement

Given a 2D grid map of `'1'`s (land) and `'0'`s (water), return the number of islands.
An **island** is surrounded by water and is formed by connecting adjacent lands **horizontally or vertically** (not diagonally).

The grid is completely surrounded by water, and you may assume all four edges of the grid are surrounded by water.

---

## Example 1

**Input:**

```text
grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
```

**Output:**

```
3
```

**Explanation:**

* First island: top-left (4 connected lands).
* Second island: middle single land.
* Third island: bottom-right (2 connected lands).

---

## Example 2

**Input:**

```text
grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0'],
  ['0','0','0','0','0']
]
```

**Output:**

```
1
```

---

## Constraints

* `1 <= m, n <= 300` (grid dimensions)
* Each `grid[i][j]` is `'0'` or `'1'`.

---

## Approach (DFS)

1. Traverse each cell of the grid.
2. If you find `'1'` (land), increment the island count.
3. Use **DFS** to visit all connected `'1'`s (up, down, left, right) and mark them as `'0'` (visited).
4. Continue until all islands are counted.

This way, each island is visited only once.

---

## Time & Space Complexity

* **Time Complexity:** `O(m * n)` — every cell is visited at most once.
* **Space Complexity:** `O(m * n)` in the worst case due to recursion stack (if the grid is all land).

---

## Java Implementation

```java
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // mark visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
```

---

## Alternate Approaches

* **BFS (Queue):** Use a queue instead of recursion to mark connected lands.
* **Union-Find (Disjoint Set):** Group connected lands into disjoint sets to count islands.

---

