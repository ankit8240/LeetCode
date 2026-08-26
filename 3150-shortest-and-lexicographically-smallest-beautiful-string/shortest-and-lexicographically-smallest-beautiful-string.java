class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="",temp;
        
        int left=0, right=0,count=0;
        for(right=0;right<s.length();right++){
             if(s.charAt(right)=='1')
            count++;

            while(count==k){
                temp=s.substring(left,right+1);
                if (ans.equals("") ||
                    temp.length() < ans.length() ||
                    (temp.length() == ans.length() && temp.compareTo(ans) < 0)) {

                    ans = temp;
            }
            if(s.charAt(left)=='1')
            count--;

        left++;
        }
        }
        return ans;
    }
}