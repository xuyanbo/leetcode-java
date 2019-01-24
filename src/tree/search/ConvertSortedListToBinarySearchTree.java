package tree.search;

import list.ListNode;
import tree.TreeNode;
import tree.traversal.BinaryTreeInorderTraversal;

import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        h = head;
        ListNode p = head;
        int len = 0;
        while(p != null) {
            ++len;
            p = p.next;
        }

        return createTreeNode(0, len-1);
    }

    public TreeNode createTreeNode(int start, int end) {
        if(start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode leftNode = createTreeNode(start, mid-1);
        TreeNode parent = new TreeNode(h.val);
        parent.left = leftNode;
        h = h.next;
        parent.right = createTreeNode(mid+1, end);

        return parent;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = new ConvertSortedListToBinarySearchTree().sortedListToBST(head);

        BinaryTreeInorderTraversal in = new BinaryTreeInorderTraversal();
        List<Integer> list = in.inorderTraversal(root);

        for(Integer val:list) {
            System.out.println(val);
        }
    }
}
