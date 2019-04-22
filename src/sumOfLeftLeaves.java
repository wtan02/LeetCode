import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int solution1(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += solution1(root.left);
        }
        ans += solution1(root.right);

        return ans;
    }

    public int solution2(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}