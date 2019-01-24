package list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode pre = node, p = head;

        while(p != null) {
            if(n == 0) {
                pre = pre.next;
            } else {
                --n;
            }

            p = p.next;
        }

        pre.next = pre.next.next;

        return node.next;
    }
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(6);

        ListNode result = new RemoveNthNodeFromEndOfList().removeNthFromEnd(l, 1);
        if(result == null) {
            System.out.println("null");
            return;
        }

        do {
            System.out.println(result.val);

            result = result.next;
        } while(result != null);
    }
}
