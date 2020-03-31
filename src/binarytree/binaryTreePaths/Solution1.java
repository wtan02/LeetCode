package binarytree.binaryTreePaths;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Traverse
 */
public class Solution1 implements binaryTreePaths {
    @Override
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(result, String.valueOf(root.val), root);
        return result;
    }

    private void helper(List<String> result, String path, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }


        if (node.left != null) {
            helper(result, path + "->" + String.valueOf(node.left.val), node.left);
        }
        if (node.right != null) {
            helper(result, path + "->" + String.valueOf(node.right.val), node.right);
        }
    }
}
