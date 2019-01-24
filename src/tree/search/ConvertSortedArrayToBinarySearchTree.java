package tree.search;

import tree.TreeNode;
import tree.traversal.BinaryTreePreorderTraversal;

import java.util.List;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        return createTree(nums, 0, nums.length-1);
    }

    public TreeNode createTree(int[] nums, int start, int end) {
        if(start > end) return null;

        int index = start + (end-start) / 2;
        TreeNode node = new TreeNode(nums[index]);

        node.left = createTree(nums, start, index-1);
        node.right = createTree(nums, index+1, end);

        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};

        ConvertSortedArrayToBinarySearchTree bst = new ConvertSortedArrayToBinarySearchTree();
        TreeNode root = bst.sortedArrayToBST(nums);

        BinaryTreePreorderTraversal pre = new BinaryTreePreorderTraversal();
        List<Integer> list = pre.preorderTraversal(root);

        for(Integer val: list) {
            System.out.println(val);
        }
    }
}
