package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;

        helper(root, res, level);

        return res;
    }

    public List<List<Integer>> helper(TreeNode root, List<List<Integer>> res, int level) {
        if(root != null) {
            if(res.size() == level) {
                res.add(0, new ArrayList<>());
            }

            res.get(res.size()-level-1).add(root.val);
            helper(root.left, res, level+1);
            helper(root.right, res, level+1);
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2, 3, 4, 5, 6, 7};

        TreeNode node = new BaseBinaryTree().createTree(tokens);
        List<List<Integer>> list = new BinaryTreeLevelOrderTraversalII().levelOrderBottom(node);

        for(List<Integer> list1 : list) {
            for(int num : list1) {
                System.out.print(num + "  ");
            }
            System.out.println(" ");
        }
    }
}
