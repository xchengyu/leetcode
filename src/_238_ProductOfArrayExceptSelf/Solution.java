/**
 * Time : O(N) ; Space: O(1)
 * @tag : Array
 * @by  : Steven Cooks
 * @date: Aug 19, 2015
 ***************************************************************************
 * Description:
 *
 * Given an array of n integers where n > 1, nums, return an array output 
 * such that output[i] is equal to the product of all the elements of nums 
 * except nums[i]. 
 * 
 * Solve it without division and in O(n). 
 * 
 * For example, given [1,2,3,4], return [24,12,8,6]. 
 * 
 * Follow up: 
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 * 
 ***************************************************************************
 * {@link https://leetcode.com/problems/product-of-array-except-self/ }
 */
package _238_ProductOfArrayExceptSelf;

/** see test {@link _238_ProductOfArrayExceptSelf.SolutionTest } */
public class Solution {

    // res[i] = A[i - 1] * B[i + 1]
    // where A[i - 1] = nums[0] * nums[1] * .. * nums[i - 1]
    //       B[i + 1] = nums[i + 1] * nums[i + 2] * .. nums[len - 1]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left; 
            left *= nums[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
