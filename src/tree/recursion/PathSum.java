package tree.recursion;

import tree.BaseBinaryTree;
import tree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, sum);
    }

    public boolean pathSum(TreeNode root, int sum) {
        if(root != null && (sum - root.val == 0) &&
                root.left == null && root.right == null) {
            return true;
        }
        if(root == null) {
            return false;
        }

        boolean leftBol = pathSum(root.left, sum - root.val);
        boolean rightBol = pathSum(root.right, sum- root.val);

        return leftBol || rightBol;
    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2};
//        Integer[] tokens = {};

        BaseBinaryTree bbt = new BaseBinaryTree();
        TreeNode root = bbt.createTree(tokens);

        System.out.println(new PathSum().hasPathSum(root, 1));
    }
}
