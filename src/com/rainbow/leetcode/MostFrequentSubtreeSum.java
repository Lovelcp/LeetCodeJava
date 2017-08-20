package com.rainbow.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
public class MostFrequentSubtreeSum {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        Arrays.stream(new MostFrequentSubtreeSum().findFrequentTreeSum(root))
              .forEach(System.out::println);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> results = new LinkedList<>();
        getSum(root);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int sum = entry.getKey();
            int cnt = entry.getValue();
            if (cnt > max) {
                max = cnt;
                results = new LinkedList<>();
                results.add(sum);
            }
            else if (cnt == max) {
                results.add(sum);
            }
        }

        return results.parallelStream()
                      .mapToInt(i -> i)
                      .toArray();
    }

    public int getSum(TreeNode root) {
        int sum = root.val;

        if (root.left != null) {
            sum += getSum(root.left);
        }

        if (root.right != null) {
            sum += getSum(root.right);
        }

        Integer cnt = map.get(sum);
        if (cnt == null) {
            cnt = 0;
        }
        map.put(sum, cnt + 1);
        return sum;
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
