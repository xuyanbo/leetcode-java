package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BaseBinaryTree {
    public TreeNode createTree(Integer[] tokens) {
        if(tokens == null || tokens.length == 0) return null;
        int index = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(tokens[index]);
        queue.add(root);

        while(true) {
            TreeNode node = queue.poll();

            if(++index < tokens.length) {
                if(tokens[index] != null) {
                    node.left = new TreeNode(tokens[index]);
                    queue.add(node.left);
                }
            } else {
                break;
            }
            if(++index < tokens.length) {
                if(tokens[index] != null) {
                    node.right = new TreeNode(tokens[index]);
                    queue.add(node.right);
                }
            } else {
                break;
            }
        }

        return root;
    }

    public TreeLinkNode createTreeWithNext(Integer[] tokens) {
        if(tokens == null || tokens.length == 0) return null;
        int index = 0;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(tokens[index]);
        root.next = null;
        queue.add(root);

        while(true) {
            TreeLinkNode node = queue.poll();

            if(++index < tokens.length) {
                if(tokens[index] != null) {
                    node.left = new TreeLinkNode(tokens[index]);
                    node.left.next = null;
                    queue.add(node.left);
                }
            } else {
                break;
            }
            if(++index < tokens.length) {
                if(tokens[index] != null) {
                    node.right = new TreeLinkNode(tokens[index]);
                    node.right.next = null;
                    queue.add(node.right);
                }
            } else {
                break;
            }
        }

        return root;
    }
}
