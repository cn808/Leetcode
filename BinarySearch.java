package Leetcode;
/**
 * BinarySearch
 */
public class BinarySearch {
/*
    problem 704 -- https://leetcode.com/problems/binary-search/

    Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. 
    If target exists, then return its index, otherwise return -1.

*/
    public static int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1,0,3,5,9,12}, 9));  // return index of 4
        System.out.println(binarySearch(new int[]{-1,0,3,5,9,12}, 2));  // return index of -1
    }
}