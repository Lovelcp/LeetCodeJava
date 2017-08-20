package com.rainbow.leetcode;

/**
 * https://leetcode.com/problems/optimal-division/description/
 */
public class OptimalDivision {
    public static void main(String[] args) {
        System.out.println(new OptimalDivision().optimalDivision(new int[] {1,2,3,4,5}));
    }

    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }

        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
}
