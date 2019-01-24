package list;

public class ReverseNodesInKGroup {
     //       pre     p  after
    // 1-->2-->3-->4-->5->6-->7-->8-->9->null k = 3
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        int len = 0;
        ListNode p = head;
        while(p != null) {
            ++len;
            p = p.next;
        }

        ListNode node = new ListNode(0);
        node.next = head;
        int num = len / k;
        ListNode pre = node, after = head.next;
        p = head;
        for(int i = 0; i < num; ++i) {
            for(int j = 0; j < k-1; ++j) {
                p.next = after.next;
                after.next = pre.next;
                pre.next = after;
                after = p.next;
            }
            pre = p;
            p = after;
            if(after != null) {
                after = after.next;
            } else {
                break;
            }
        }

        return node.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);

        ListNode result = new ReverseNodesInKGroup().reverseKGroup(l, 1);
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
