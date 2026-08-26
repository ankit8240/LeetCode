class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0;
        int n = fruits.length, maxLen=0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right<n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>=3){
                map.put(fruits[left] , map.get(fruits[left])-1);

                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                    
                }
                left++;
            }
            int curLen= right-left +1;
            maxLen= Math.max(maxLen,curLen);
            right++;
        }
        return maxLen;
    }
}