package com.rainbow.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        new FindLargestValueInEachTreeRow().largestValues(root)
                                           .forEach(System.out::println);
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        Integer max = null;

        while (true) {
            Queue<TreeNode> nextLevelNodes = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                if (max == null) {
                    max = node.val;
                }
                else if (node.val > max) {
                    max = node.val;
                }

                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }

            result.add(max);
            max = null;

            if (nextLevelNodes.isEmpty()) {
                break;
            }

            nodes = nextLevelNodes;
        }

        return result;
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
