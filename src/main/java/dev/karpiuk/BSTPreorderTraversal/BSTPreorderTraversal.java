package dev.karpiuk.BSTPreorderTraversal;

import java.util.Stack;

public class BSTPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }

    public static void main(String[] args) {
        BSTPreorderTraversal bstPreorderTraversal = new BSTPreorderTraversal();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstPreorderTraversal.bstFromPreorder(preorder);
        System.out.println(root.val);
    }

}
