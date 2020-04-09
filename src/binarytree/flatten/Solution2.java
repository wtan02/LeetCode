package binarytree.flatten;

import binarytree.TreeNode;

public class Solution2 implements flatten {

    @Override
    public void flatten(TreeNode root) {
        if(root==null){
            return ;
        }
        findLastNodeAfterFlattenTree(root);
    }

    public TreeNode findLastNodeAfterFlattenTree(TreeNode root){
        if(root==null){
            return null;
        }
        //diviede
        TreeNode leftLast = findLastNodeAfterFlattenTree(root.left);//2-3-4
        TreeNode rightLast  = findLastNodeAfterFlattenTree(root.right);//5-6
        //conquer
        //合并 1-2-3-4-5-6
        if(leftLast!=null){
            leftLast.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        //如果右边存在 则最后一个节点一定是右边的最后一个节点
        if(rightLast!=null){
            return rightLast;
        }
        //如果右边不存在 则最后一个节点一定是左边的最后一个节点
        if(leftLast!=null){
            return leftLast;
        }
        //最后返回根节点
        return root;
    }
}
