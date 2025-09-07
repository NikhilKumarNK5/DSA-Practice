package GFG.LinkedList;

/*
Given a linked list, and a number, check if their exist two numbers whose sum is equal to given number.
If there exist two numbers, print them. If there are multiple answer, print any of them.

Examples:
Input : 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        sum = 3
Output : Pair is (1, 2)

Input : 10 -> 12 -> 31 -> 42 -> 53 -> NULL
        sum = 15
Output : NO PAIR EXIST
*/

import java.util.HashSet;

public class LinkedListPairSum {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Approach 1: Brute force - for every pair compare and if exists a pair then return
    // TC => O(N^2)
    // SC => O(1)
    public boolean check_pair_sum_BruteForce(Node head, int sum) {
        Node p = head;
        Node q;

        while(p != null) {
            q = p.next;
            while(q != null) {
                if((p.data + q.data) == sum) {
                    return true;
                }
                q = q.next;
            }
            p = p.next;
        }
        return false;
    }

    // Approach 2: Using Hashing - store the value of node into hashSet and check if the difference exists in the set and if it does the return true
    // TC => O(N)
    // SC => O(N)
    public boolean check_pair_sum(Node head, int sum) {
        HashSet<Integer> set = new HashSet<>();

        Node p = head;
        while(p != null) {
            int curr = p.data;
            if(set.contains(sum - curr))
                return true;
            set.add(p.data);
            p = p.next;
        }
        return false;
    }
}
