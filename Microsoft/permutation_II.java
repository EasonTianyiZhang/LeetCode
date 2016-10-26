/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:

[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

public class Solution {
    List<List<Integer>> res;
    List<Integer> tmp;
    int n;
    boolean[] used;
    int[] nums;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<List<Integer>>();
        n = nums.length;
        if (n == 0) return res;
        
        this.nums = nums;
        Arrays.sort(this.nums);
        tmp = new LinkedList<Integer>();
        used = new boolean[n];
        
        backTracking();
        return res;
    }
    
    
    private void backTracking(){
        if (tmp.size() == n){
            res.add(new LinkedList(tmp));
        }
        else{
            for (int i = 0; i < n; i ++){
                if (used[i] || i > 0 && !used[i-1] && nums[i] == nums[i-1])continue;
                else{
                    tmp.add(nums[i]);
                    used[i] = true;
                    backTracking();
                    tmp.remove(tmp.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}