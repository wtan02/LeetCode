import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leafSimilar {
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

    public boolean solution_1(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        findAllLeafNodes(root1, leaves1);
        findAllLeafNodes(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void findAllLeafNodes(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }
            findAllLeafNodes(node.left, leafValues);
            findAllLeafNodes(node.right, leafValues);
        }
    }

    public boolean solution_2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while ( !stack1.isEmpty() && !stack2.isEmpty()) {
            if (findLeafNode(stack1) != findLeafNode(stack2))
                return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int findLeafNode(Stack<TreeNode> stack) {
        while(true) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            if (node.left == null && node.right == null) return node.val;
        }
    }
}
