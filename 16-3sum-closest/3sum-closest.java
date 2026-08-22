class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = nums[0]+nums[1]+nums[2];
        int sum =0;
      for(int i=0;i<nums.length-2;i++){
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
         sum = nums[i]+nums[j]+nums[k];
        if(Math.abs(sum-target)< Math.abs(close - target)){
            close = sum;
        }
        if(sum == target){
        return target;
        }
        else if(sum>target){
            k--;
        }
        else{
            j++;
        }
        
      }  
      }
      return close;
    }
}