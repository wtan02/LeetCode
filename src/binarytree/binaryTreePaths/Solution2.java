package binarytree.binaryTreePaths;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 implements binaryTreePaths {
    @Override
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();

        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String leftPath : leftPaths) {
            paths.add(String.valueOf(root.val) + "->" + leftPath);
        }
        for (String rightPath : rightPaths) {
            paths.add(String.valueOf(root.val) + "->" + rightPath);
        }

        if (paths.size() == 0) {
            paths.add(String.valueOf(root.val));
        }

        return paths;
    }
}
