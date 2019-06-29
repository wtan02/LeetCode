package tree.isBalanced;

import tree.TreeNode;

/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

class Solution {
    public boolean isBalanced(TreeNode root) {
        return postOrderTraversal(root) != -1;
    }
    
    private int postOrderTraversal(TreeNode node) {
        if (node == null) return 0;
        
        int left = postOrderTraversal(node.left);
        if (left != -1) {
            int right = postOrderTraversal(node.right);
            if (right != -1) {
                return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
            }
        }
        return -1;
    }
}