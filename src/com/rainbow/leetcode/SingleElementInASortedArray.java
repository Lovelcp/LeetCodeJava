package com.rainbow.leetcode;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(new int[] {3,3,7,7,10,10,11}));
    }

    public int singleNonDuplicate(int[] nums) {
        int index = (nums.length - 1) / 2;
        while (true) {
            if (index == 0 || index == nums.length - 1) {
                return nums[index];
            }

            int num = nums[index];
            if (nums[index - 1] != nums[index] && nums[index + 1] != nums[index]) {
                return num;
            }

            if (nums[index - 1] == nums[index]) {
                index = index + (nums.length - index) / 2;
            }
            else {
                index = index / 2;
            }
        }
    }

    public int find(int index, int[] nums) {
        if (index == 0 || index == nums.length - 1) {
            return nums[index];
        }

        int num = nums[index];
        if (nums[index - 1] != nums[index] && nums[index + 1] != nums[index]) {
            return num;
        }

        if (nums[index - 1] == nums[index]) {
            return find(index + (nums.length - index) / 2, nums);
        }
        else {
            return find(index / 2, nums);
        }
    }
}
