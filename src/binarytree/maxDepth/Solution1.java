package binarytree.maxDepth;

import binarytree.TreeNode;

/*
 * Divide & Conquer
 */
public class Solution1 implements maxDepth{

    private static int CURRENT_ROW_DEPTH = 1;
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + CURRENT_ROW_DEPTH;
    }
}
