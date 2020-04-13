package binarytree.inorderTraversal;

import binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 implements inorderTraversal {
    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode curt = root;
        //ATTEN：为何必须有两个或条件
        //Curt为null时候是在curt走到任意左子树尽头
        //Stack为空时是走到根结点
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            //只有在curt弹出栈时加入list
            result.add(curt.val);

            curt = curt.right;
        }
        return result;
    }
}
