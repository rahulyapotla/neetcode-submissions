/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
//             int max_sum = Integer.MIN_VALUE;

//     public int maxPathSum(TreeNode root) {
//         if ( root == null)
//             return 0;
//         int left_sum = maxPathSum(root.left);
//         int right_sum = maxPathSum(root.right);
//         max_sum = Math.max(max_sum, (left_sum + right_sum + root.val));
//         return max_sum;
//     }
// }

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        maxSum = Math.max(maxSum,
                          node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain, rightGain);
    }
}
