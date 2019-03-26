import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (62.47%)
 * Total Accepted:    37.5K
 * Total Submissions: 60K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree.  From left to right order, the
 * values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 *
 * Both of the given trees will have between 1 and 100 nodes.
 *
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LeafSimilar {
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
    //Solution 1: Find all leaf nodes and compare in the end
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

    //Solution 2: Compare leaf nodes on the fly
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
    //Given stack, compare find a leaf node
    private int findLeafNode(Stack<TreeNode> stack) {
        while(true) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            if (node.left == null && node.right == null) return node.val;
        }
    }
}
