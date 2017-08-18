package com.rainbow.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
//        a.left.left = new TreeNode(4);
//        a.left.left.left = new TreeNode(10);
//        a.right.left = new TreeNode(5);
//        a.right.right = new TreeNode(6);
//        a.right.left.left = new TreeNode(7);
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue1(a));
    }

    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                continue;
            }
            result = node.val;
            nodes.add(node.right); // 先塞入右节点
            nodes.add(node.left);
        }
        return result;
    }

    public int findBottomLeftValue1(TreeNode root) {
        return findBottomLeftValue1(root, 1, new int[] { 0, 0 });
    }

    public int findBottomLeftValue1(TreeNode root, int depth, int[] res) {
        if (res[1] < depth) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null)
            findBottomLeftValue1(root.left, depth + 1, res);
        if (root.right != null)
            findBottomLeftValue1(root.right, depth + 1, res);
        return res[0];
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
