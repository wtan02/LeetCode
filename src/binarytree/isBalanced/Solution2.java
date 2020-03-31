package binarytree.isBalanced;

import binarytree.TreeNode;

class ResultType {
    public int height;
    public boolean isBalanced;
    public ResultType(int height, boolean isBalanced){
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

public class Solution2 implements isBalanced {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(0, true);
        }

        ResultType leftResult = helper(node.left);
        ResultType rightResult = helper(node.right);

        ResultType result = new ResultType(Math.max(leftResult.height, rightResult.height) + 1, true);

        if (!leftResult.isBalanced || !rightResult.isBalanced) {
            result.isBalanced = false;
        }

        if (Math.abs(leftResult.height - rightResult.height) > 1) {
            result.isBalanced = false;
        }
        return result;
    }
}
