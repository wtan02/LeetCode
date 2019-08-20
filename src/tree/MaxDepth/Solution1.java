package tree.MaxDepth;

import tree.Node;

public class Solution1 implements MaxDepth{
    @Override
    public int maxDepth(Node root){
        if (root == null) return 0;

        int depth = 1;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child) + 1) ;
        }
        return depth;
    }
}
