class Solution {
    public int missingMultiple(int[] nums, int k) {
        int find;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int i=1;
        while(true){
            find = k*i;
            if(! set.contains(find))
            return find;
            else
            i++;
        }
    }
}