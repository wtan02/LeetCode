package tree.isUnivalTree;

import tree.TreeNode;

public class Solution1 implements isUnivalTree{
    @Override
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        else
            return recursive(root, root.val);
    }

    private boolean recursive(TreeNode root, int value) {
        if (root == null) return true;
        return (root.val == value) && recursive(root.left, value) && recursive(root.right, value);
    }
}
