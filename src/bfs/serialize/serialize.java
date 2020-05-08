package bfs.serialize;

import binarytree.TreeNode;

public interface serialize {
    String serialize(TreeNode root);

    TreeNode deserialize(String data);
}
