package sort;

import list.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode tmp, prev = new ListNode(-1), head = prev;
        prev.next = l1;
        while(l1 != null) {
            while(l2 != null) {
                if(l1.val > l2.val) {
                    tmp = l2;
                    l2 = l2.next;
                    prev.next = tmp;
                    tmp.next = l1;
                    prev = tmp;
                } else {
                    prev = l1;
                    break;
                }
            }
            l1 = l1.next;
        }

        if(l2 != null) {
            prev.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(9);

        ListNode head = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
