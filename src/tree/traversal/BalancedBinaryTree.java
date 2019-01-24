package tree.traversal;


import tree.BaseBinaryTree;
import tree.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return balanceHeight(root) >= 0;
    }

    public int balanceHeight(TreeNode root) {
        if(root == null) return 0;

        int left = balanceHeight(root.left);
        int right = balanceHeight(root.right);

        if(left < 0 || right < 0 || Math.abs(left-right) < 1) return -1;

        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        Integer[] tokens1 = {1, 2, 3, null, null, 5, 6};

        TreeNode node1 = new BaseBinaryTree().createTree(tokens1);
        boolean flag = new BalancedBinaryTree().isBalanced(node1);

        System.out.println(flag);
    }
}
