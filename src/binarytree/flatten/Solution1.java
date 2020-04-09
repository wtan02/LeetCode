package binarytree.flatten;

import binarytree.TreeNode;
/*
 * Traverse. Always use the latest
 */
public class Solution1 implements flatten {
    TreeNode lastNode = null;
    @Override
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode rightChild = root.right;
        flatten(root.left);
        flatten(rightChild);
    }
}
