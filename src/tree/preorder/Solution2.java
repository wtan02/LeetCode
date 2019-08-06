package tree.preorder;

import tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class Solution2 implements preorder{
    @Override
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Deque<Node> stack = new ArrayDeque<>();
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--)
                stack.offerLast(node.children.get(i));
        }
        return result;
    }
}
