public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int n = nums.length;
        
        int b = 0;
        int e = n-1;
        while(b < e){
            int m = b + (e - b)/2;
            if (nums[m] < nums[0]) e = m;
            else b = m+1;
        }
        if (nums[b] >= nums[0]) b = 0;
        int p = b;
        
        
        b = 0;
        e = n-1;
        while(b < e){
            int m = b + (e - b)/2;
            if (nums[(m+p)%n] == target) return (m+p)%n;
            else if (nums[(m+p)%n] > target) e = m-1;
            else b = m+1;
        }
        
        if (nums[(b+p)%n] == target) return (b+p)%n;
        return -1;
        
    }
}