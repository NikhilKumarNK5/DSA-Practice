package LeetCode.BinaryTrees;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
*/

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
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

    // Approach 1: Recursive
    // TC => O(N)
    // SC => O(N)
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0; // depth is 0 is the tree is empty

        // otherwise check recursively the maxDepth of left and right subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int maxDepth = 1 + Math.max(leftDepth, rightDepth);
        return maxDepth;
    }

    // Approach 2: Using Queues - level order traversal
    // TC => O(N)
    // SC => O(N)
    public int maxDepthQueues(TreeNode root) {
        // if the tree is empty then the maxDepth is 0
        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int levels = 0;

        while(!q.isEmpty()) {
            levels++; // incrementing level once we traverse through a level
            for(int i = 0; i < q.size(); i++) {
                TreeNode temp = q.poll();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return levels;
    }
}
