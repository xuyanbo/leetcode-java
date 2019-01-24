package list;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node, p = head;
        boolean flag = false;

        do{
            if(p.next != null && p.val == p.next.val) {
                p = p.next;
                flag = true;
            } else {
                if(flag) {
                    pre.next = p.next;
                    flag = false;
                } else {
                    pre = p;
                }
                p = p.next;
            }
        } while(p != null);

        return node.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
//        l.next.next = new ListNode(2);
//        l.next.next.next = new ListNode(3);
//        l.next.next.next.next = new ListNode(3);
//        l.next.next.next.next.next = new ListNode(3);

        ListNode result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(l);
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
