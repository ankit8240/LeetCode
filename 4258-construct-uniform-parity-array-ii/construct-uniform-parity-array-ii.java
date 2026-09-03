class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallOdd = Integer.MAX_VALUE;
        for(int num : nums1){
            if(num %2 ==1)
            smallOdd = Math.min(smallOdd,num);
        }
        if(smallOdd == Integer.MAX_VALUE)
        return true;

        for(int num : nums1){
            if(num % 2 == 0 && num<= smallOdd)
            return false;
        }
        return true;
    }
}