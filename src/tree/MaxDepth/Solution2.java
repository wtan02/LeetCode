package tree.MaxDepth;

import tree.Node;

import java.util.*;

public class Solution2 implements MaxDepth{
    @Override
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int levels = 0;
        Deque<List<Node>> nodes = new ArrayDeque<>(); // contains nodes at each level
        nodes.add(Arrays.asList(root));
        while (nodes.peek() != null) {
            List<Node> levelNodes = nodes.poll();
            ++levels;
            List<Node> nextLevelNodes = new ArrayList<>(); //contains nodes at the next level
            for (Node node : levelNodes) {
                nextLevelNodes.addAll(node.children);
            }
            if (nextLevelNodes.size() > 0) {
                nodes.add(nextLevelNodes);
            }
        }
        return levels;
    }
}
