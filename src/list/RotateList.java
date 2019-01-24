package list;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode node = new ListNode(0);
        node.next = head;
        int len = 0;
        ListNode start = head, end = head;

        while(head != null) {
            ++len;
            head = head.next;
        }

        int subLen = k % len;
        while(end.next != null) {
            if(subLen == 0) {
                start = start.next;
            } else {
                subLen--;
            }
            end = end.next;
        }

        end.next = node.next;
        node.next = start.next;
        start.next = null;

        return node.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(6);

        ListNode result = new RotateList().rotateRight(l, 3);
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

