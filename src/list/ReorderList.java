package list;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;

        ListNode start = head, center = head, end = head;

        int count = 0;
        while(end.next != null) {
            if(count != 0 && count % 2 == 0) {
                center = center.next;
            }
            end = end.next;
            ++count;
        }
        center = center.next;

       ListNode newList = center.next;
       center.next = null;
       ListNode prev = null;
       while(newList != null) {
           ListNode tmpNode = newList.next;
           newList.next = prev;
           prev = newList;
           newList = tmpNode;
       }

        while(start != null && prev != null) {
            ListNode temp = start.next;
            start.next = prev;
            ListNode newListTemp = prev.next;
            prev.next = temp;
            start = temp;
            prev = newListTemp;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(6);
//        l.next.next.next.next.next.next = new ListNode(7);

        new ReorderList().reorderList(l);
        if(l == null) {
            System.out.println("null");
            return;
        }

        do {
            System.out.println(l.val);

            l = l.next;
        } while(l != null);
    }
}
