package tree.construct;

import tree.TreeNode;
import tree.traversal.BinaryTreePreorderTraversal;

import java.util.List;

public class ConstructBinaryTreeInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(0, postorder.length-1, inorder.length-1, inorder, postorder);
    }

    public TreeNode createTree(int postStart, int postEnd, int inEnd, int[] inoder, int[] postorder) {
        if(postStart > postEnd) return null;
        int inIndex = -1;
        TreeNode root = new TreeNode(postorder[postEnd]);

        for (int i = 0; i < inoder.length; i++) {
            if(postorder[postEnd] == inoder[i]) {
                inIndex = i;
                break;
            }
        }

        int rightNum = inEnd - inIndex;

        root.left = createTree(postStart, postEnd-rightNum-1, inIndex-1, inoder, postorder);
        root.right = createTree(postEnd-rightNum, postEnd-1, inEnd, inoder, postorder);

        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {8, 9, 4, 16, 17, 10, 11, 5, 2};
        int[] inorder = {8, 4, 9, 2, 16, 10, 17, 5, 11};

        TreeNode root = new ConstructBinaryTreeInorderAndPostorderTraversal().buildTree(inorder, postorder);

        List<Integer> list = new BinaryTreePreorderTraversal().preorderTraversal(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
