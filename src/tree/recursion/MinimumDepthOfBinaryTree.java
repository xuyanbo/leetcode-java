package tree.recursion;

import tree.BaseBinaryTree;
import tree.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        return treeDepth(root, 1);
    }

    public int treeDepth(TreeNode root, int depth) {
        if(root == null) return -1;

        if(root.left == null && root.right == null) return depth;

        depth++;
        int leftDepth = treeDepth(root.left, depth);
        int rightDepth = treeDepth(root.right, depth);

        if(leftDepth > rightDepth) {
            if(rightDepth != -1) {
                return rightDepth;
            } else {
                return leftDepth;
            }
        } else {
            if(leftDepth != -1) {
                return leftDepth;
            } else {
                return rightDepth;
            }
        }
    }

    public static void main(String[] args) {
        //Integer[] tokens = {1,2,3,4,null,null,5};
        Integer[] tokens = {};

        BaseBinaryTree bbt = new BaseBinaryTree();
        TreeNode root = bbt.createTree(tokens);

        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
    }
}
