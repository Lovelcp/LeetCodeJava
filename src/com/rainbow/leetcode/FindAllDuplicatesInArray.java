package com.rainbow.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * 利用原数组来保存信息
 */
public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = new int[] {4,3,2,7,8,2,3,1,1};
        new FindAllDuplicatesInArray().findDuplicates(nums).forEach(System.out::println);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(num));
            }
            else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}
