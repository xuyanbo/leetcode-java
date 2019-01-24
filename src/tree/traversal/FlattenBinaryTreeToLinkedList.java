package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null)  return ;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        while(left != null && left.right != null) left = left.right;

        if(left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2, 5, 3, 4, null, 6};

        TreeNode root = new BaseBinaryTree().createTree(tokens);
        new FlattenBinaryTreeToLinkedList().flatten(root);

        while(root != null) {
            System.out.println(root.val);
            if(root.left != null) {
                System.out.println("=="+root.left.val);
            }
            root = root.right;
        }
    }
}
