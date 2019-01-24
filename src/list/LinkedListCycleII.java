package list;

public class LinkedListCycleII {
    // 1->2->3->4->5->6->7->8->9
    //    |____________________|
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head, fast = head.next;
        int count = 0;
        while(slow != fast) {
            if(fast == null || fast.next == null) return null;

            slow = slow.next;
            fast = fast.next.next;
        }

        do{
            count++;
            slow = slow.next;
        } while(slow != fast);

        ListNode pre = head, p = head.next;

        while(p.next != pre) {
            if(count == 0) {
                pre = pre.next;
                p = p.next;
            } else {
                p = p.next;
                --count;
            }
        }

        return pre;
    }

    public ListNode betterDetectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                ListNode slow2 = head;
                while(slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = head;
//        ListNode p1 = new ListNode(2);
//        head.next = p1;
//        ListNode p2 = new ListNode(3);
//        p1.next = p2;
//        ListNode p3 = new ListNode(4);
//        p2.next = p3;
//        ListNode p4 = new ListNode(5);
//        p3.next = p4;
//        p4.next = p3;

        ListNode result = new LinkedListCycleII().betterDetectCycle(head);
        if(result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("null");
        }

    }
}
