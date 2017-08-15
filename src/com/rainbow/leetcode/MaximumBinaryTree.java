package com.rainbow.leetcode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 * <p>
 * 分别实现了递归解法和迭代解法
 * <p>
 * 递归的比较好理解，迭代的不太好理解
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 5, 4, 9, 1, 7, 6, 8, 10, 2, 3 };

        TreeNode result1 = new MaximumBinaryTree().recursiveSolution(nums1);

        int[] nums2 = new int[] { 9, 1, 2, 7, 5, 4, 6, 8 };
        TreeNode result2 = new MaximumBinaryTree().iterationSolution(nums2);
    }

    public TreeNode recursiveSolution(int[] nums) {
        if (nums == null)
            return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int idxMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idxMax]) {
                idxMax = i;
            }
        }

        TreeNode root = new TreeNode(nums[idxMax]);

        root.left = build(nums, start, idxMax - 1);
        root.right = build(nums, idxMax + 1, end);

        return root;
    }

    public TreeNode iterationSolution(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);

        TreeNode last = root;

        for (int i = 1; i < nums.length; i++) {
            TreeNode current = new TreeNode(nums[i]);

            if (nums[i] < nums[i - 1]) {
                // 挂在nums[i-1]右边
                last.right = current;
            }
            else {
                if (nums[i] > root.val) {
                    // 将当前树直接整个挂在current的左边
                    current.left = root;
                    root = current;
                }
                else {
                    TreeNode right = root;
                    while (true) {
                        if (right.right.val < nums[i]) {
                            current.left = right.right;
                            right.right = current;
                            break;
                        }
                        right = right.right;
                    }
                }
            }

            last = current;
        }

        return root;
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
