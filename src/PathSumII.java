import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> solution(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);

        if(root.left==null && root.right==null ){
            if(root.val==sum)
                //Copy constructor, the advantage is that we only copy a list when we add to the final result
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left,sum-root.val,res,path);
            //Remove reference from child layer
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right,sum-root.val,res,path);
            //Remove reference from child layer
            path.remove(path.size()-1);
        }

    }
}
