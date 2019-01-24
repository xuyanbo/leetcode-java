package tree.recursion;

import tree.BaseBinaryTree;
import tree.TreeNode;

public class SumRootToLeafNumbers {
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        pathNumers(root, 0);

        return sum;
    }

    public void pathNumers(TreeNode node, int num) {
        num = num * 10 + node.val;

        if(node.left == null && node.right == null) {
            sum += num;
            return ;
        }

        if(node.left != null) pathNumers(node.left, num);
        if(node.right != null) pathNumers(node.right, num);

        return ;
    }

    public static void main(String[] args) {
        Integer[] tokens = {4,9,0,5,1};

        BaseBinaryTree bbt = new BaseBinaryTree();
        TreeNode root = bbt.createTree(tokens);

        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}
