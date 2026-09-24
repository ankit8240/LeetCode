class Solution {
    public int smallestIndex(int[] nums) {
        
        
        int min = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            
            

            if(digitSum(nums[i])==i)
            return i;
        
        }
        
        return -1;
    }

public int digitSum(int i){
    int sum=0;

    while(i>0){
        sum+=  i%10;
        i=i/10;
    }
    return sum;
}
}