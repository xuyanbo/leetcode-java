package tree.recursion;

import tree.BaseBinaryTree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        pathSumList(root, list, sum);

        return result;
    }

    public void pathSumList(TreeNode root, List<Integer> list, int sum) {
        if(root != null && (sum - root.val == 0) &&
                root.left == null && root.right == null) {
            result.add(list);
        }
        if(root == null) {
            return ;
        }
        list.add(root.val);

        List<Integer> leftList = new ArrayList<>();
        leftList.addAll(list);
        pathSumList(root.left, leftList, sum - root.val);
        List<Integer> rightList = new ArrayList<>();
        rightList.addAll(list);
        pathSumList(root.right, rightList, sum- root.val);

        return ;
    }

    public List<List<Integer>> betterPathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        betterPathSumList(root, sum, new ArrayList<>(), result);

        return result;
    }

    public void betterPathSumList(TreeNode root, int remain, List<Integer> list, List<List<Integer>> result) {
        list.add(root.val);

        if(remain == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }

        if(root.left != null) {
            betterPathSumList(root.left, remain - root.val, list, result);
        }
        if(root.right != null) {
            betterPathSumList(root.right, remain - root.val, list, result);
        }

        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        Integer[] tokens = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};

        BaseBinaryTree bbt = new BaseBinaryTree();
        TreeNode root = bbt.createTree(tokens);

        List<List<Integer>> result = new PathSumII().pathSum(root, 22);

        for(List<Integer> list: result) {
            for(int val :list) {
                System.out.print(val + "   ");
            }
            System.out.println(" ");
        }
    }
}
