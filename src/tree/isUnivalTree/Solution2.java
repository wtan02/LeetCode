package tree.isUnivalTree;

import tree.TreeNode;

public class Solution2 implements isUnivalTree{
    @Override
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        boolean isLeftUnival = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));

        boolean isRightUnival = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));

        return isLeftUnival && isRightUnival;
    }
}
