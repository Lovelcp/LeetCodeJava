package com.rainbow.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/description/
 * 证明原理：https://discuss.leetcode.com/topic/87206/java-solution-sorting-and-rough-proof-of-algorithm
 */
public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 4, 3, 2 };
        assert new ArrayPartition1().arrayPairSum(nums) == 4;
    }

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
