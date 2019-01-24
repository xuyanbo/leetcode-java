package tree.construct;

import tree.TreeNode;
import tree.traversal.BinaryTreePreorderTraversal;

import java.util.List;

public class ConstructBinaryTreePreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;

        return createTree(0, preorder.length-1, 0, preorder, inorder);
    }

    public TreeNode createTree(int preStart, int preEnd, int inStart, int[] preoder, int[] inorder) {
        if(preStart > preEnd) return null;
        int inIndex = -1;
        TreeNode root = new TreeNode(preoder[preStart]);

        for (int i = 0; i < inorder.length; i++) {
            if(preoder[preStart] == inorder[i]) {
                inIndex = i;
                break;
            }
        }
        int leftNum = inIndex - inStart;

        root.left = createTree(preStart + 1, preStart + leftNum, inStart, preoder, inorder);
        root.right = createTree(preStart + leftNum + 1, preEnd, inIndex+1, preoder, inorder);

        return root;
    }

    public static void main(String[] args) {
        int[] preoder = {2, 4, 8, 9, 5, 10, 16, 17, 11};
        int[] inorder = {8, 4, 9, 2, 16, 10, 17, 5, 11};

        TreeNode root = new ConstructBinaryTreePreorderAndInorderTraversal().buildTree(preoder, inorder);

        List<Integer> list = new BinaryTreePreorderTraversal().preorderTraversal(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
