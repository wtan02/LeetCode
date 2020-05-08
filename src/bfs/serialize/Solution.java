package bfs.serialize;

import binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution implements serialize{

    @Override
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("#");
            } else {
                result.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            result.append(",");
        }
        return result.toString();
    }

    @Override
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            for (int i = 0; i < 2; i++) {
                String child = values[index++];
                if (!child.equals("#")) {
                    TreeNode childNode = new TreeNode(Integer.parseInt(child));
                    queue.offer(childNode);
                    if (i == 0) {
                        parent.left = childNode;
                    } else {
                        parent.right = childNode;
                    }
                }
            }
        }
        return root;
    }
}
