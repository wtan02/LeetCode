package binarytree.preorderTraversal;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Non-recursive
 */
public class Solution3 implements preorderTraversal {
    @Override
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
