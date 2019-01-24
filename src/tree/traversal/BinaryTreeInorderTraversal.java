package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inOrder(list, root);

        return list;
    }

    public void inOrder(List<Integer> list, TreeNode node) {
        if(node != null) {
            if(node.left != null) {
                inOrder(list, node.left);
            }
            list.add(node.val);
            if(node.right != null) {
                inOrder(list, node.right);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2, 3, 4, 5, 6, 7};

        TreeNode node = new BaseBinaryTree().createTree(tokens);

        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal(node);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
