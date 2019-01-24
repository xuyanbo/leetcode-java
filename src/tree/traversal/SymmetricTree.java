package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null || p.val != q.val) return false;

        return helper(p.left, q.right) && helper(p.right, q.left);
    }

    public static void main(String[] args) {
        Integer[] tokens1 = {1,2,2,3,4,4,3};

        TreeNode node1 = new BaseBinaryTree().createTree(tokens1);
        boolean flag = new SymmetricTree().isSymmetric(node1);

        System.out.println(flag);
    }
}
