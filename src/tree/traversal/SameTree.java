package tree.traversal;


import tree.BaseBinaryTree;
import tree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null ||  q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Integer[] tokens1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Integer[] tokens2 = {1, 2, 3, 4, 5, 6, 7};

        TreeNode node1 = new BaseBinaryTree().createTree(tokens1);
        TreeNode node2 = new BaseBinaryTree().createTree(tokens2);
        boolean flag = new SameTree().isSameTree(node1, node2);

        System.out.println(flag);
    }
}
