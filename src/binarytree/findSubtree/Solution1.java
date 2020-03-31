package binarytree.findSubtree;

import binarytree.TreeNode;

public class Solution1 implements findSubtree {
    int minSum = Integer.MAX_VALUE;
    TreeNode minNode;

    @Override
    public TreeNode findSubtree(TreeNode root) {
        // write your code here

        if (root == null) return root;

        sumSubTree(root);

        return minNode;
    }

    private int sumSubTree(TreeNode root) {
        if (root == null) return 0;

        int leftSum = sumSubTree(root.left);
        int rightSum = sumSubTree(root.right);

        int sumValue = leftSum + rightSum + root.val;
        if (sumValue <= minSum) {
            minSum = sumValue;
            minNode = root;
        }

        return sumValue;
    }
}
