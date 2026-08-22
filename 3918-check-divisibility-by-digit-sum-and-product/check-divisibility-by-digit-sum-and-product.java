class Solution {
    public boolean checkDivisibility(int n) {
        int temp =n;
        int sum=0;
        int pro =1;
        while(n>0){
            int a=n%10;
            sum+=a;
            pro*=a;
            n=n/10;
        }
        int totalSum=sum+pro;
        if(temp%totalSum==0)
        return true ;
        else 
        return false;
    }
}