package Leetcode.recommanded_problems;

/**
 * MaxSubArray
 */
public class MaxSubArray {
/*
    problem 53 -- https://leetcode.com/problems/maximum-subarray/

    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int largestSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        for(int num: nums) {
            sumSoFar += num;
            if(sumSoFar < num) sumSoFar = num;
            largestSum = Math.max(largestSum, sumSoFar);
        }

        return largestSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // should return 6
        System.out.println(maxSubArray(new int[]{1, 2, 4, 0, -1, 3, -7, 1})); // should return 9
        System.out.println(maxSubArray(new int[]{1})); // should return 1
        System.out.println(maxSubArray(new int[]{0})); // should return 0
        System.out.println(maxSubArray(new int[]{-1})); // should return -1
        System.out.println(maxSubArray(new int[]{-2147483647})); // should return -2147483647
    }
}