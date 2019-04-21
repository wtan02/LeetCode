/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class sortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode solution1(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int smaller, int greater) {
        if (smaller > greater) { // Done
            return null;
        }
        int mid = (smaller + greater) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, smaller, mid - 1);
        node.right = helper(num, mid + 1, greater);
        return node;
    }
}
