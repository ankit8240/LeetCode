class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0;
        int digsum=0;
        for(int num: nums){
            sum+=num;
            if(num>9){
                digsum+= DigSum(num);
            }else
            {
                digsum+= num;
            }
        }
        return Math.abs(sum-digsum);
    }
    public int DigSum(int n){
        int di=0;
        while(n>0){
            di+= n%10;
            n=n/10;
        }
        return di;
    }
}