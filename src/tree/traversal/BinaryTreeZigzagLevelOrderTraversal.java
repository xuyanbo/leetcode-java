package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;

        helper(root, res, level);

        return res;
    }

    public List<List<Integer>> helper(TreeNode root, List<List<Integer>> res, int level) {
        if(root != null) {
            if(res.size() == level) {
                res.add(new ArrayList<>());
            }

            if(level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
            helper(root.left, res, level+1);
            helper(root.right, res, level+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2, 3, 4, 5, 6, 7};

        TreeNode node = new BaseBinaryTree().createTree(tokens);
        List<List<Integer>> list = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node);

        for(List<Integer> list1 : list) {
            for(int num : list1) {
                System.out.print(num + "  ");
            }
            System.out.println(" ");
        }
    }
}
