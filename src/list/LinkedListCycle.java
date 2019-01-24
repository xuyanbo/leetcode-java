package list;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        head.next = p1;
        ListNode p2 = new ListNode(3);
        p1.next = p2;
        ListNode p3 = new ListNode(4);
        p2.next = p3;
        ListNode p4 = new ListNode(5);
        p3.next = p4;
        p4.next = p2;


        boolean result = new LinkedListCycle().hasCycle(head);

        System.out.println(result);
    }
}
