class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int c=0, sum=0;
        for(int price : prices){
            sum += price;
            if(money>=sum){
            c++;
            }
            if(c==2)
            return money-sum;
        }
        return money;
    }
}