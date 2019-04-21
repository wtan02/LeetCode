import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class convertBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int sum = 0;
    public TreeNode solution1(TreeNode root) {
        if (root != null) {
            solution1(root.right);
            sum += root.val;
            root.val = sum;
            solution1(root.left);
        }
        return root;
    }

    public TreeNode solution2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

        //reverse in-order traversal
        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }
        return root;
    }
}