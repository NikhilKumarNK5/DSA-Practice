package GFG.LinkedList;

/*
Given the head of a linked list, determine whether the list contains a loop. If a loop is present,
return the number of nodes in the loop, otherwise return 0.
Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to.
If pos = 0, it means the last node points to null, indicating there is no loop.
Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
Output: 4
Explanation: There exists a loop in the linked list and the length of the loop is 4.

Input: pos = 3,
Output: 3
Explanation: The loop is from 19 to 10. So length of loop is 19 → 33 → 10 = 3.

Input: pos = 0,
Output: 0
Explanation: There is no loop.
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^4
0 ≤ pos < number of nodes
*/

public class FindLengthOfLoop {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Approach: Detect the cycle, once cycle detected, fixed one pointer and moved around it to count the length
    // TC => O(N)
    // SC => O(1)
    public int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                // loop detected - count the length
                int loopLength = 1;
                Node temp = slow.next;
                while(temp != slow) {
                    loopLength++;
                    temp = temp.next;
                }
                return loopLength;
            }
        }

        return 0;
    }
}
