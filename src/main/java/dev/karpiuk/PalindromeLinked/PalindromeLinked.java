package dev.karpiuk.PalindromeLinked;

import java.util.Stack;

public class PalindromeLinked {

    public boolean isPalindrome(ListNode head) {

        int length = 0;
        ListNode h = head;
        Stack<Integer> stack = new Stack<>();

        while (h != null) {
            length++;
            stack.push(h.val);
            h = h.next;
        }
        int i = 0;
        while (i < (length / 2)) {
            if (head.val != stack.pop()) {
                return false;
            }
            i++;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinked palindromeLinked = new PalindromeLinked();
        ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(palindromeLinked.isPalindrome(head));
    }

}
