package LeetCode.LinkedList;

/*
Given the head of a singly linked list where elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Example 2:
Input: head = []
Output: []

Constraints:
The number of nodes in head is in the range [0, 2 * 10^4].
-10^5 <= Node.val <= 10^5
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class ConvertSortedListToBinarySearchTree {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode left) { this.val = val; this.next = next; }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Approach: Since the list is sorted, and we need a height balance BST, we can take the middle as root
    // After that recursively find the left and right subtrees
    // TC => O(NlogN)
    // SC => O(N)
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    // Helper function with head and tail
    private TreeNode toBST(ListNode head, ListNode tail) {
        if(head == tail)
            return null;

        ListNode mid = findMiddle(head, tail);
        TreeNode root = new TreeNode(mid.val);

        root.left = toBST(head, mid);
        root.right = toBST(mid.next, tail);

        return root;
    }

    // Find middle node between head (inclusive) and tail (exclusive)
    private ListNode findMiddle(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
