class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<0){
            return false;
        }
        if(c==1 || c==2)
        return true;
        int i = 0;
        long j=(long) Math.sqrt(c);
        while(i<=j){
            
        long sum = (long) i*i + (long)j*j;
        if(sum == c)
        return true;
        else if(sum < c)
        i++;
        else j--;
    }
    return false;
}
}