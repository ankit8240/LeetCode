class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num :nums){
            set.add(num);
            
        }
        int longest =0;
        for(int num:set){
            if(!set.contains(num -1)){
                int curr = num;
                int c =1;
                while(set.contains(curr +1)){
                    curr++;
                    c++;
                }
                longest = Math.max(longest,c);
            }
            
        }
        return longest;
    }
}