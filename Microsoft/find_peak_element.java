

/*

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Complexity: O(lg n)

*/

public class Solution {
    public int findPeakElement(int[] nums) {
        /*
        
        The main idea of this question is
        find any "first 1" in any "1 - group" in the sequence
        
        0 0 0 0 1 1 1 1 0 0 0 1 1 0 0 1 1 0
        
        where 0 is nums[i] < nums[i+1] and nums[i] > nums[i+1]
        */
        
        int b = 0;
        int e = nums.length - 1;
        while(b < e){
            int m = b + (e - b)/2;
            if (nums[m] < nums[m+1]) b = m+1;
            else e = m;
        }
        
        return b;
        
    }
}