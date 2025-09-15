package LeetCode.BinaryTrees;

/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-10^4 <= root.val <= 10^4
-10^4 <= subRoot.val <= 10^4
*/

public class SubtreeOfAnotherTree {
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

    // Approach 1: Using recursion
    // TC => O(N * M)
    // SC => O(N * M)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if the root is null it can't have subRoot
        if(root == null)
            return false;
        if(isSameTree(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        // if both are null then they are same
        if(node == null && subRoot == null)
            return true;
        // if either is null or the value is not equal they are different
        if(node == null || subRoot == null || node.val != subRoot.val)
            return true;
        // recursively check left and right subtree for both
        return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
    }


    // Approach 2: Serialize both and then check if equal
    // TC => O(N + M)
    // SC => O(N + M)
    public boolean isSubtreeSerialize(TreeNode root, TreeNode subRoot) {
        String rootString = serialize(root);
        String subRootString = serialize(subRoot);

        return rootString.equals(subRootString);
    }

    private String serialize(TreeNode node) {
        if(node == null)
            return "#";
        StringBuilder sb = new StringBuilder(" ");
        sb.append(node.val);
        sb.append(serialize(node.left));
        sb.append(serialize(node.right));

        return sb.toString();
    }

}
