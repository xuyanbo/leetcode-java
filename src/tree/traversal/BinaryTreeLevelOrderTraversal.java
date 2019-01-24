package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        while(queue.size() != 0) {
            TreeNode node = queue.poll();
            if(node == null) {
                list.add(subList);
                if(!queue.isEmpty()) {
                    subList = new ArrayList<>();
                    queue.add(null);
                }
            } else {
                subList.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return list;
    }

    public List<List<Integer>> betterLevelOrder(TreeNode root) {
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

            res.get(level).add(root.val);
            helper(root.left, res, level+1);
            helper(root.right, res, level+1);
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] tokens = {1, 2, 3, 4, 5, 6, 7};

        TreeNode node = new BaseBinaryTree().createTree(tokens);
        List<List<Integer>> list = new BinaryTreeLevelOrderTraversal().betterLevelOrder(node);

        for(List<Integer> list1 : list) {
            for(int num : list1) {
                System.out.print(num + "  ");
            }
            System.out.println(" ");
        }
    }
}
