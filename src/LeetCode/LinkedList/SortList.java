package LeetCode.LinkedList;

/*
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
*/

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

public class SortList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Approach: Merge Sort
    // Find mid, recursively sort both halves, merge the sorted halves
    // TC => O(NLogN)
    // SC => O(1)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        // find the middle of the list
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // merge the sorted halves
        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null)
            tail.next = l1;
        if(l2 != null)
            tail.next = l2;

        return result.next;
    }
}
