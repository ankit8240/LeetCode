class Solution {
    public boolean checkIfPangram(String sentence) {
        int sum =0;
        int[] freq = new int[128];
        for(char ch : sentence.toCharArray()){
            if (ch >= 'a' && ch <= 'z')
            freq[ch - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]==0)
            return false;
        }
        return true;
    }
}