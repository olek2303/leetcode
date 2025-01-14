package dev.karpiuk.RemDuplicates;

public class RemDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        if (h == null) {
            return null;
        }
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        RemDuplicates remDuplicates = new RemDuplicates();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = remDuplicates.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
