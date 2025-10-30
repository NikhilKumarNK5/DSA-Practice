package LeetCode.BinaryTrees;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:
The number of nodes in the tree is in the range [2, 10^5].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the BST.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfABinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Approach: checking left or right subtree using the property of BST
    // TC => O(H) // O(logN) for balanced tree, O(N) for skewed
    // SC => O(1)
    // The code only works if it is stated that both p and q exists in the tree, if they do not exist we may get incorrect results
    // To overcome this we can add another check to make sure that both p and q exists then only move further otherwise return null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        while(root != null) {
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    // to check if both p and q exists then proceed
    // TC => O(H)
    // SC => O(H)
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(!exists(root, p) || !exists(root, q))
           return null;

        TreeNode lca = findLca(root, p, q);
        return lca;
    }

    private boolean exists(TreeNode root, TreeNode node) {
        if(root == null)
            return false;
        if(root.val == node.val)
            return true;
        return exists(root.left, node) || exists(root.right, node);
    }

    private TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        while(root != null) {
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

}
