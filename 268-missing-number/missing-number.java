class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
             
        }
        for(int i=0;i<=nums.length;i++){
            if(!map.containsKey(i))
            return i;
        }
        return -1;
    }
}