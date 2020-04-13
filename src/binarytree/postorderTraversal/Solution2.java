package binarytree.postorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
 * Traverse
 */
public class Solution2 implements postorderTraversal {
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);

        return;
    }
}
