package list;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        List<ListNode> list = new ArrayList();
        ListNode p = head;

        float center = (m+n)/2.f;
        int i = 1, tmp;
        do{
            if(i >= m && i < center) {
                list.add(p);
            }
            if(i > center && i <= n) {
                tmp = p.val;
                ListNode node = list.get(list.size()-1);
                p.val = node.val;
                node.val = tmp;
                list.remove(list.size()-1);
            }
            p = p.next;
            ++i;
        } while(p != null);

        return head;
    }

    public ListNode betterReverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode pre = node;
        for(int i = 0; i < m-1; ++i) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode after = start.next;

        for(int i = 0; i < n-m; ++i) {
            start.next = after.next;
            after.next = pre.next;
            pre.next = after;
            after = start.next;
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

        ListNode result = new ReverseLinkedListTwo().betterReverseBetween(l, 2, 6);

        do {
            System.out.println(result.val);

            result = result.next;
        } while(result != null);
    }
}
