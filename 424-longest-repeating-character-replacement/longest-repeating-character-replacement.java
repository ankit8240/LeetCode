class Solution {
    public int characterReplacement(String s, int k) {
        int high=0, low=0, res = Integer.MIN_VALUE;
        int[] f = new int [256];
        for(high=0;high<s.length();high++){
            f[s.charAt(high)]++;
            int len= high -low+1;
            int maxCount = find(f);
            int diff = len - maxCount;
            while(diff>k){
                f[s.charAt(low)]--;
                low++;
                len = high - low +1;
                maxCount = find(f);
                diff = len - maxCount;

            }
            len = high - low +1;
            res = Math.max(res,len);
        }
        return res;
    }

    public int find(int[] a){
        int max =-1;
        for(int i=0;i<256;i++)
        max = Math.max(max,a[i]);
        return max;
    }
}