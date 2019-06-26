/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class longestUnivaluePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        //Maximum between left child and right child
        int sub = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        //Maximum between passing through and not passing through
        return Math.max(sub, maxThroughRoot(root.left, root.val) + maxThroughRoot(root.right, root.val));
    }

    //maximum number of same nodes including root node
    private int maxThroughRoot(TreeNode node, int val) {
        if (node == null || node.val != val) return 0;
        return 1 + Math.max(maxThroughRoot(node.left, val), maxThroughRoot(node.right, val));
    }
}