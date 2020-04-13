package binarytree.preorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Divide & Conquer
 */
public class Solution1 implements preorderTraversal {

    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        //Divide
        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);

        //Conquer
        result.add(root.val);
        result.addAll(leftList);
        result.addAll(rightList);

        return result;
    }
}
