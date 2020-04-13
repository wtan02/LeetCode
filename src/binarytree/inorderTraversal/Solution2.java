package binarytree.inorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Traverse
 */
public class Solution2 implements inorderTraversal{
    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.left, result);
        result.add(node.val);
        helper(node.right, result);

        return;
    }
}
