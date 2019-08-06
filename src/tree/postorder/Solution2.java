package tree.postorder;

import tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 implements postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(root);

        while(!stack1.empty())
        {
            Node top = stack1.pop();
            stack2.push(top);
            for(int i = 0; i < top.children.size(); i++)
                stack1.push(top.children.get(i));
        }

        while(!stack2.empty())
            list.add(stack2.pop().val);

        return list;
    }
}
