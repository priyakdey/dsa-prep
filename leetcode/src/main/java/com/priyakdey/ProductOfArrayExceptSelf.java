package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ProductOfArrayExceptSelf {

    // NOTE: Compute prefix and suffix products in one pass (without division).
    // product[i] = prefixProduct * suffixProduct
    // Update from both ends simultaneously.
    // Time: O(n), Space: O(1) (output array doesn't count).

    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        Arrays.fill(product, 1);

        int prefixProduct = 1, suffixProduct = 1;
        int left = 1, right = nums.length - 2;

        while (left < nums.length) {
            prefixProduct *= nums[left - 1];
            product[left] *= prefixProduct;
            left++;

            suffixProduct *= nums[right + 1];
            product[right] *= suffixProduct;
            right--;
        }

        return product;
    }

}
