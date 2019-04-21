import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class postorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> treeNodeStack = new LinkedList<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                result.add(node.val);
                treeNodeStack.pop();
                lastVisit = node;
                //将null赋值给node，因为不需要在下一轮再把node的左子树入栈
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
        return result;
    }
}
