package tree.search;


import tree.BaseBinaryTree;
import tree.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long lower, long upper) {
        if(root == null) {
            return true;
        }

        if(root.val <= lower || root.val >= upper) {
            return false;
        }

        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }

    public static void main(String[] args) {
        Integer[] tokens = {2147483647};

        TreeNode node = new BaseBinaryTree().createTree(tokens);

        System.out.println(new ValidateBinarySearchTree().isValidBST(node));
    }
}
