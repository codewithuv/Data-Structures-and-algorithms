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
