package binarytree.postorderTraversal;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 先入栈左子树，再入栈右子树，这样会先筛选右子树点点，然后将其逆向insert到队列头从而达到先访问左子树再右子树最后root
 */
public class Solution3 implements postorderTraversal{
    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //将curl所在node加入链表尾
            result.addFirst(node.val);
            // 左子树先入栈
            if (node.left != null) {
                stack.push(node.left);
            }
            // 右子树后入栈，先出栈
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }
}
