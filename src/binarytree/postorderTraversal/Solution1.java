package binarytree.postorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
 * Divide & Conquer
 */
public class Solution1 implements postorderTraversal {
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // Divide
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        //Conquer
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}
