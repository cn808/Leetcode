package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SortedArrayToBST
 */
public class SortedArrayToBST {
/*
    problem 704 -- https://leetcode.com/problems/binary-search/

    Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. 
    If target exists, then return its index, otherwise return -1.

*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private static TreeNode buildBST(int[] nums, int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new SortedArrayToBST().new TreeNode(nums[mid]);
        treeNode.left = buildBST(nums, start, mid - 1);
        treeNode.right = buildBST(nums, mid + 1, end);
        
        return treeNode;
    }

    private static void printBSTByDepth(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) q).push(root);

        while(!q.isEmpty()) {
            System.out.print(q.peek().val + " ");
            int elementOnThisLevel = q.size();
            for(int i = 0; i < elementOnThisLevel; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) ((LinkedList<TreeNode>) q).push(curr.left);
                if(curr.right != null) ((LinkedList<TreeNode>) q).push(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode res = sortedArrayToBST(new int[]{-10,-3,0,5,9});  // return index of [0,-3,9,-10,null,5]
        printBSTByDepth(res);
    }
}