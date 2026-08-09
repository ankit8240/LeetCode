class Solution {
    public String firstPalindrome(String[] words) {
         

        int i=0;
        while(i<words.length){
            if(isPalin(words[i])){
                return words[i];
            }
            i++;
        }
        return "";
    } 
    public boolean isPalin(String word){
            
            int j=word.length()-1;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)== word.charAt(j)){
                    j--;
                }else
                return false;
            }
            return true;
        }
}