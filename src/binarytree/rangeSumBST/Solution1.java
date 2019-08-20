package binarytree.rangeSumBST;

import binarytree.TreeNode;

public class Solution1 implements rangeSumBST{
    private int ans = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        preOrderTraversal(root, L, R);
        return ans;
    }

    private void preOrderTraversal(TreeNode node, int L, int R) {
        if (node == null) return;
        if (L <= node.val && node.val <= R) {
            ans += node.val;
        }
        if (L < node.val ) {
            preOrderTraversal(node.left, L, R);
        }
        if (node.val < R) {
            preOrderTraversal(node.right, L, R);
        }
    }


}
