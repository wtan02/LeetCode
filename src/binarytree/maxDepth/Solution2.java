package binarytree.maxDepth;

import binarytree.TreeNode;
/*
 * Traverse
 */
public class Solution2 implements maxDepth {

    private int maxDepth = 0;

    @Override
    public int maxDepth(TreeNode root) {
        helper(root, 0);
        return maxDepth;
    }

    private void helper(TreeNode node, int currentDepth) {
        if (node == null) {
            return;
        }

        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }

        helper(node.left, currentDepth + 1);
        helper(node.right, currentDepth + 1);
    }
}
