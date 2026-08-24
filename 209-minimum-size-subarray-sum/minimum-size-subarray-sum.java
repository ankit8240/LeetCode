class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int low=0,high=0,sum=0,check=0;
       int res = Integer.MAX_VALUE;
       for(int num :nums){
        check+= num;
       }
       if(check<target)
       return 0;
       while(high < nums.length){
        sum+= nums[high];

        while(sum>= target){
            int len = high-low +1;
             res= Math.min(res,len);
            sum -= nums[low];
            low++;
        }
        high++;
       } 
       return res;
    }
}