package list;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pre = head, p = head.next;

        do{
            if(pre.val == p.val) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;

        } while(p != null);

        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);

        ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(l);

        do {
            System.out.println(result.val);

            result = result.next;
        } while(result != null);
    }
}
