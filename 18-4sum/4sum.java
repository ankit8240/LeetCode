class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int i,j,k,l;
        long sum=0;
        Arrays.sort(nums);
        for( i =0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1])
            continue;
             for( j =i+1;j<nums.length-2;j++){
            if(j> i + 1 && nums[j]==nums[j-1])
            continue;
         
         k=j+1;
         l = nums.length-1;
        while(k<l){
            sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
            if(sum == target){
        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
    k++;
    l--;
   
    while(k<l && nums[k]==nums[k-1]){
        k++;
    }
    while(k<l && nums[l]==nums[l+1]){
        l--;
    }
            }
    else if(sum >target){
        l--;
    }
    else{
        k++;
    }
        }
        }
        }
        return res;
    }
}