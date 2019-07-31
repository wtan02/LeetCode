package tree.mergeTrees;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 implements mergeTrees {
    // Method 3: Iterative BFS using queue
    // Time: O(n)
    // Space: O(n)

    @Override
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // Use stack to help DFS
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {t1, t2});
        while (!queue.isEmpty()) {
            TreeNode[] cur = queue.poll();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
            }
        }
        return t1;
    }
}
