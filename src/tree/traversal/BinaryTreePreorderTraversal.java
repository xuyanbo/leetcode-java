package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preOrder(list, root);

        return list;
    }

    public void preOrder(List<Integer> list, TreeNode node) {

        if(node != null) {
            list.add(node.val);
            if(node.left != null) {
                preOrder(list, node.left);
            }
            if(node.right != null) {
                preOrder(list, node.right);
            }
        }

    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2, null, null, 5, 6, 7};

        TreeNode node = new BaseBinaryTree().createTree(tokens);

        List<Integer> list = new BinaryTreePreorderTraversal().preorderTraversal(node);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
