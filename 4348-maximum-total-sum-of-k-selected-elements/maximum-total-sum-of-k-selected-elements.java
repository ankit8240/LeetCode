class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
    
    long sum =0;
    int i=nums.length-1;
     while(k>0){
        long max =  Math.max((long)nums[i],(long)nums[i]*mul);
        sum += max;
        k--;
        mul--;
        i--;
     }
       
        return sum;
    }
}