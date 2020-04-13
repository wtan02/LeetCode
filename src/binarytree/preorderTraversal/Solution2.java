package binarytree.preorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Traverse
 */
public class Solution2 implements preorderTraversal {
    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

        private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
        return;
    }
}
