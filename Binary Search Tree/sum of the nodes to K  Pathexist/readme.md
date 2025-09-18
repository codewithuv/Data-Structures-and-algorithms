
---

# 🌳 Binary Tree Path Sum

## 🔹 Problem Statement

You are given a **Binary Tree** and an integer **x**.
You need to determine if there exists a **root-to-leaf path** such that the **sum of all node values along that path = x**.

---

## 🔹 Example 1

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \
7    2
```

**Input:**

```
x = 22
```

**Output:**

```
true
```

✅ Path found: `5 → 4 → 11 → 2` → Sum = 22

---

## 🔹 Example 2

```
      1
     / \
    2   3
```

**Input:**

```
x = 5
```

**Output:**

```
false
```

❌ Paths are `1 → 2 = 3` and `1 → 3 = 4`, none equal 5.

---

## 🔹 Solution Approach

1. Start from the root node.
2. Subtract the current node’s value from the target sum.
3. Recursively check the left and right subtrees.
4. If you reach a **leaf node** and the remaining sum equals the node’s value → path exists.
5. If no path satisfies the condition, return false.

---

## 🔹 Java Implementation

```java
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check left & right subtrees
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        /*
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \
        7    2
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum)); // Output: true
    }
}
```

---

## 🔹 Complexity Analysis

* **Time Complexity**: `O(N)` → visits each node once.
* **Space Complexity**: `O(H)` → recursion stack, where `H` is tree height.

---

## 🔹 Extensions

* Modify the code to return **all possible root-to-leaf paths** that sum to `x`.
* Can be adapted for problems like **Path Sum II** (LeetCode 113).

---

