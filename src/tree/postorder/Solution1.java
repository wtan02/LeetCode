package tree.postorder;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution1 implements postorder {
    List<Integer> result = new ArrayList<>();

    @Override
    public List<Integer> postorder(Node root) {
        if (root == null) return result;
        for (Node node : root.children)
            postorder(node);

        result.add(root.val);
        return result;
    }
}
