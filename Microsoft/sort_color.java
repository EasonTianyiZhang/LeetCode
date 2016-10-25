public class Solution {
    public void sortColors(int[] nums) {
        int b = 0;
        int e = nums.length - 1;
        int i = 0;
        while(i < nums.length){

            while (nums[i] == 2 && i < e) swap(nums, i, e--);
            
            while (nums[i] == 0 && i > b) swap(nums, i, b++);
            
            i++;

        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}