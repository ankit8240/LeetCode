class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = nums[0];
        boolean zero = false;
       for(int i=1;i<nums.length;i++){
         ans = ans ^ nums[i];
         if(nums[i] != 0){
            zero = true;
         }
       } 
       if(ans !=0)
       return nums.length;

       if(zero)
       return nums.length-1;

       return 0;
    }
}