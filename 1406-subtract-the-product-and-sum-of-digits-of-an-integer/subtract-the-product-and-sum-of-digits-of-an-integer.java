class Solution {
    public int subtractProductAndSum(int n) {
        
        int product =1 , sum =0;
        while(n>0){
            sum+= n%10;
            product *= n%10;
            n=n/10;
        }
        int ans =product - sum;
        return ans;
    }
}