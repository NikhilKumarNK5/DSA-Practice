package LeetCode.BinaryTrees;

/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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

    // Approach: Using Recursive DFS
    // TC => O(N^2)
    // SC => O(N^2)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root != null) {
            dfs(root, "", res);
        }
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {

        if(root.left == null && root.right == null) {
            // leaf node, add the path
            res.add(path + root.val);
            return;
        }

        // not a leaf, keep building the path
        if(root.left != null)
            dfs(root.left, path + root.val + "->", res);
        if(root.right != null)
            dfs(root.right, path + root.val + "->", res);
    }
}
