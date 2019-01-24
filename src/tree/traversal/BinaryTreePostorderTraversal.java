package tree.traversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postOrder(list, root);

        return list;
    }

    public void postOrder(List<Integer> list, TreeNode node) {
        if(node != null) {
            if(node.left != null) {
                postOrder(list, node.left);
            }
            if(node.right != null) {
                postOrder(list, node.right);
            }
            list.add(node.val);
        }
    }
}
