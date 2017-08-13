package com.rainbow.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 * 关键点：采用递归的解法。一般树类型的题目都可尝试使用递归来解题。递归的思路就是先写出当前递归层级的做法，然后递归调用。
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        // tree 1
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        // tree 2
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        TreeNode t3 = new MergeTwoBinaryTrees().mergeTrees(t1, t2);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode resultRoot = new TreeNode(t1.val + t2.val);

        resultRoot.left = mergeTrees(t1.left, t2.left);
        resultRoot.right = mergeTrees(t1.right, t2.right);

        return resultRoot;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { t1, t2 });
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            }
            else {
                stack.push(new TreeNode[] { t[0].left, t[1].left });
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            }
            else {
                stack.push(new TreeNode[] { t[0].right, t[1].right });
            }
        }
        return t1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

