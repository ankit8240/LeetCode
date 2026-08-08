class Solution {
    public int strStr(String haystack, String needle) {
        if(! haystack.contains(needle) || needle.length() > haystack.length())
        {
                return -1;
        }
        int j=needle.length();
        for(int i=0;i<haystack.length();i++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
            j++;
        }
        return -1;
    }
}