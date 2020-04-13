package binarytree.inorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
 * Divide & Conquer
 */
public class Solution1 implements inorderTraversal {
    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        // Divide
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        //Conquer
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }
}
