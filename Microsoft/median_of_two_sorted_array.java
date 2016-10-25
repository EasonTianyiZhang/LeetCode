public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length)%2 == 0){
            int a = kth(nums1, 0, nums2, 0, (nums1.length + nums2.length)/2);
            int b = kth(nums1, 0, nums2, 0, (nums1.length + nums2.length)/2+1);
            return (a+b)/2.0;
        }
        else return kth(nums1, 0, nums2, 0, (nums1.length + nums2.length)/2+1);
        
    }
    
    
    private int kth(int[] nums1, int s1, int[] nums2, int s2, int k){
        if (s1 >= nums1.length)
            return nums2[s2 + k -1];
        if (s2 >= nums2.length)
            return nums1[s1 + k -1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);
        
        int m1 = s1 + k/2 - 1;
        int m2 = s2 + k/2 - 1;
        int v1 = (m1 < nums1.length)? nums1[m1] : Integer.MAX_VALUE;
        int v2 = (m2 < nums2.length)? nums2[m2] : Integer.MAX_VALUE;
        if (v1 <= v2)
            return kth(nums1, m1+1, nums2, s2, k - k/2);
        else
            return kth(nums1, s1, nums2, m2+1, k - k/2);
    }
}