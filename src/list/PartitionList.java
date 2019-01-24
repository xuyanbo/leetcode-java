package list;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode index = node, pre = node, p = node.next;
        boolean flag = false;

        do{
            if(p.val < x) {
                if(flag) {
                    pre.next = p.next;
                    p.next = index.next;
                    index.next = p;

                    index = p;
                    p = pre.next;

                } else {
                    index = p;
                    pre = p;
                    p = p.next;
                }

            } else {
                pre = p;
                if(!flag){
                    flag = true;
                }
                p = p.next;
            }

        } while(p != null);

        return node.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(3);
        l.next = new ListNode(1);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(2);
//        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(2);


        ListNode result = new PartitionList().partition(l, 2);

        do {
            System.out.println(result.val);

            result = result.next;
        } while(result != null);
    }
}
