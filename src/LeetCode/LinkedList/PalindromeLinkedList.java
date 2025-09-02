package LeetCode.LinkedList;

/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space?
*/

import java.util.Stack;

public class PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        static class ListNode {
            private int val;
            private ListNode next;

            public ListNode(int val) {
                this.val = val;
            }

            public void setNext(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }

            public ListNode getNext() {
                return this.next;
            }
        }

        // Approach 1: Using Stack - push up-to the middle and then compare and pop
        public boolean isPalindromeStack(ListNode head) {
            // count nodes
            int n = 0;
            ListNode curr = head;
            while(curr != null) {
                n++;
                curr = curr.next;
            }

            // push first half onto stack
            Stack<Integer> stack = new Stack<>();
            curr = head;
            for(int i = 0; i < n / 2; i++) {
                stack.push(curr.val);
                curr = curr.next;
            }

            // skip middle node for odd length
            if(n % 2 == 1)
                curr = curr.next;

            // compare second half with stack
            while(curr != null) {
                if(stack.pop() != curr.val)
                    return false;
                curr = curr.next;
            }
            return true;
        }

        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            // find the middle
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            if(fast != null)
                slow = slow.next;

            // reverse the second half
            slow = reverseList(slow);
            fast = head;

            // start comparing one by one
            while(slow != null) {
                if(fast.val != slow.val)
                    return false;
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while(curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }
    }
}
