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
class Solution {
    int mx;

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int s1 = left[0], lmin = left[1], lmax = left[2], v1 = left[3];
        int s2 = right[0], rmin = right[1], rmax = right[2], v2 = right[3];

        if ((root.left != null && root.val <= root.left.val) || (lmax != Integer.MAX_VALUE && root.val <= lmax))
            v1 = 0;

        if ((root.right != null && root.val >= root.right.val) || (rmin != Integer.MIN_VALUE && root.val >= rmin))
            v2 = 0;

        if (lmin == Integer.MIN_VALUE) lmin = root.val;
        if (rmax == Integer.MAX_VALUE) rmax = root.val;

        if (v1 == 1 && v2 == 1) {
            int total = s1 + s2 + root.val;
            mx = Math.max(mx, total);
            return new int[]{total, lmin, rmax, 1};
        }

        return new int[]{Integer.MIN_VALUE, -1, -1, 0};
    }

    public int maxSumBST(TreeNode root) {
        mx = 0;
        dfs(root);
        return mx;
    }
}