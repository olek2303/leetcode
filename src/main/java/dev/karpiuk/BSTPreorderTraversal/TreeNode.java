package dev.karpiuk.BSTPreorderTraversal;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode() {}   TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}