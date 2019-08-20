package binarytree.searchBST;

import binarytree.TreeNode;

public class Solution2 implements searchBST {

    @Override
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
