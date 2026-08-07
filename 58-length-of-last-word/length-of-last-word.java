class Solution {
    public int lengthOfLastWord(String s) {
        String []arr = s.split(" ");
        int n = arr.length;
        String ans = arr[n-1].trim();

         return ans.length();
    }
}