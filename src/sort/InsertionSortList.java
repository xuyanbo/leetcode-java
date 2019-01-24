package sort;

import list.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode prev = new ListNode(Integer.MIN_VALUE);
        prev.next = head;
        ListNode cur = head, result = prev, tmp, tmpprev, tmpcur;

        while(cur != null) {
            if(cur.val < prev.val) {
                tmp = cur;
                prev.next = cur.next;
                cur = cur.next;

                tmpcur = result.next;
                tmpprev = result;
                while(tmpcur.val <= tmp.val) {
                    tmpcur = tmpcur.next;
                    tmpprev = tmpprev.next;
                }

                tmpprev.next = tmp;
                tmp.next = tmpcur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(8);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(10);

        ListNode head = new InsertionSortList().insertionSortList(l1);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
