package tree.rangeSumBST;

import tree.TreeNode;

public class solution2 implements rangeSumBST{
    public int rangeSumBST(TreeNode node, int L, int R) {

        if (node == null) return 0;

        if (node.val < L) return rangeSumBST(node.right, L, R);
        if (node.val > R) return rangeSumBST(node.left, L, R);

        return node.val + rangeSumBST(node.left, L, R) + rangeSumBST(node.right, L, R);
    }
}
