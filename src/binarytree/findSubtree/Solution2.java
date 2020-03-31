package binarytree.findSubtree;

import binarytree.TreeNode;

class ResultType {
    int sum, minSum;
    TreeNode minSumNode;

    public ResultType(int sum, int minSum, TreeNode minSumNode) {
        this.sum = sum;
        this.minSum = minSum;
        this.minSumNode = minSumNode;
    }
}

public class Solution2 implements findSubtree{
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        return helper(root).minSumNode;
    }

    public ResultType helper(TreeNode root) {
        if (root == null)
            return new ResultType(0, Integer.MAX_VALUE, root);

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);

        ResultType result = new ResultType(leftResult.sum + rightResult.sum + root.val, leftResult.sum + rightResult.sum + root.val, root);

        if (leftResult.minSum <= result.minSum) {
            result.minSum = leftResult.minSum;
            result.minSumNode = leftResult.minSumNode;
        }

        if (rightResult.minSum <= result.minSum) {
            result.minSum = rightResult.minSum;
            result.minSumNode = rightResult.minSumNode;
        }

        return result;
    }
}