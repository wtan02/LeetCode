package tree.preorder;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution1 implements preorder {
    List<Integer> result = new ArrayList<>();

    @Override
    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);
        for(Node node : root.children)
            preorder(node);

        return result;
    }
}
