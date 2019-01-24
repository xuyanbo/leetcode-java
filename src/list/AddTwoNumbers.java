package list;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, index = 0;
        ListNode p = null, l = null;

        do{
            sum = l1.val + l2.val + index;
            index = 0;
            if(sum / 10 != 0) {
                index = sum / 10;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            if(l == null) {
                l = node;
                p = node;
            } else {
                p.next = node;
                p = node;
            }

            l1 = l1.next;
            l2 = l2.next;
        } while(l1 != null && l2 != null);

        if(l1 != null) {
            addRestList(l1, index, p);
        } else {
            addRestList(l2, index, p);
        }

        return l;
    }

    public void addRestList(ListNode l, int index, ListNode p) {
        int sum;
        if(index == 0) {
            p.next = l;
        } else {
            while(l != null && index != 0) {
                sum = l.val + index;
                index = 0;
                if(sum / 10 != 0) {
                    index = sum / 10;
                    sum = sum % 10;
                }
                l.val = sum;
                p.next = l;
                p = l;
                l = l.next;
            }
            if(l != null) {
                p.next = l;
            }
            if(index != 0) {
                p.next = new ListNode(index);
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode l3 = new AddTwoNumbers().addTwoNumbers(l1, l2);
        do {
            System.out.println(l3.val);

            l3 = l3.next;
        } while(l3 != null);

    }
}
