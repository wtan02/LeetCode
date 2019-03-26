import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (58.23%)
 * Total Accepted:    73.4K
 * Total Submissions: 126K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 *
 * Example 1:
 *
 * Input:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on
 * level 2 is 11. Hence return [3, 14.5, 11].
 *
 *
 *
 * Note:
 *
 * The range of node's value is in the range of 32-bit signed integer.
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
public class AverageOfLevels {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //Solution 1: DFS
    public List<Double> solution_1(TreeNode root) {
        List < Integer > count = new ArrayList< >();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }

    public void average(TreeNode t, int level, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;

            //When some node from this level has been visited, update sum and count
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + t.val);
            count.set(level, count.get(level) + 1);
            //First time to visit this level, add sum and count
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }

        average(t.left, level + 1, sum, count);
        average(t.right, level + 1, sum, count);
    }

    //Solution 2: BFS, visit in level order
    public List<Double> solution_2(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int numberOfNodesInCurrentLevel = queue.size();
            double sum = 0, count = 0;
            for (int i = 0; i < numberOfNodesInCurrentLevel; i++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                count++;
                if (node.left != null) queue.offer(node.left);
                if (node.right !=null) queue.offer(node.right);
            }
            result.add(sum / count);
        }
        return result;
    }
}
