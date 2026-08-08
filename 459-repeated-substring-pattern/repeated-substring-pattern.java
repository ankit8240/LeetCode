class Solution {
    public boolean repeatedSubstringPattern(String s) {
       /* int[]freq = new int[128];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;

        }
        int j=1;
        for(int i=0;i<128;i++){
            if(freq[i] == freq[j]){
            j++;
            }
            else 
            return false;
        }
        return true;
    }
}

*/

        String doubled = s + s;

        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}