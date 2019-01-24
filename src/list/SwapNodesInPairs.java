package list;

public class SwapNodesInPairs {
    // 1->2->3->4->5->6->null
    // pre -> p --> after-->
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==  null) return head;

        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node, p = head, after = head.next;

        while(after != null) {
            pre.next = after;
            p.next = after.next;
            after.next = p;
            pre = p;
            p = p.next;
            if(p != null) {
                after = p.next;
            } else {
                break;
            }
        }

        return node.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        l.next = new ListNode(8);
//        l.next.next = new ListNode(2);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(3);
//        l.next.next.next.next.next = new ListNode(4);

        ListNode result = new SwapNodesInPairs().swapPairs(l);
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
