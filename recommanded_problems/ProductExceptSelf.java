package Leetcode.recommanded_problems;

/**
 * ProductExceptSelf
 */
public class ProductExceptSelf {
/*
    problem 238 -- https://leetcode.com/problems/product-of-array-except-self/

    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
*/
    public static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;

        int inputLength = nums.length;
        int[] res = new int[inputLength];

        int fromLeft = 1;
        for(int i = 0; i < inputLength; i++) {
            if(i > 0) fromLeft = fromLeft * nums[i - 1];
            res[i] = fromLeft;
        }

        int fromRight = 1;
        for(int i = inputLength - 1; i >= 0; i--) {
            if(i < inputLength - 1) fromRight = fromRight * nums[i + 1];
            res[i] = fromRight * res[i];
        }

        return res;
    }

    private static void printArray(int[] input) {
        for(int i : input) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        printArray(productExceptSelf(new int[]{1,2,3,4})); // should return [24,12,8,6]
    }
}