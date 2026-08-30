class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        
        if(nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxI=0;
        int minI=0;
        for(int num:nums){
            max= Math.max(max,num);
            min= Math.min(min,num);

        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max)
             maxI = i;
            if(nums[i]==min)
             minI = i;
        }
    int front = Math.max(maxI,minI)+1;
    int end = nums.length - Math.min(maxI,minI);
    int mixed = Math.min(maxI,minI)+1 + nums.length -Math.max(maxI,minI);
    return Math.min(front,Math.min(end,mixed));
    }
}