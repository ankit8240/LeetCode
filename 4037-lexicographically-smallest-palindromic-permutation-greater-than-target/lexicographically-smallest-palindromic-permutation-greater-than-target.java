class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        int oddCount = 0;
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }
        
        if (oddCount > 1 || (oddCount == 1 && n % 2 == 0)) {
            return "";
        }
        
        int halfLen = n / 2;
        int[] halfCnt = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }
        
        char[] halfStr = new char[halfLen];
        int matched = 0;
        for (int i = 0; i < halfLen; i++) {
            int tIdx = target.charAt(i) - 'a';
            if (halfCnt[tIdx] > 0) {
                halfStr[i] = target.charAt(i);
                halfCnt[tIdx]--;
                matched++;
            } else {
                break;
            }
        }
        
        for (int i = matched; i >= 0; i--) {
            if (i < matched) {
                halfCnt[halfStr[i] - 'a']++;
            }
            if (i == halfLen) {
                String possible = buildPalindrome(halfStr, halfCnt, oddChar, n);
                if (possible.compareTo(target) > 0) {
                    return possible;
                }
                continue;
            }
            
            int tIdx = target.charAt(i) - 'a';
            for (int c = tIdx + 1; c < 26; c++) {
                if (halfCnt[c] > 0) {
                    halfStr[i] = (char) ('a' + c);
                    halfCnt[c]--;
                    
                    int ptr = i + 1;
                    for (int j = 0; j < 26; j++) {
                        while (halfCnt[j] > 0) {
                            halfStr[ptr++] = (char) ('a' + j);
                            halfCnt[j]--;
                        }
                    }
                    return buildPalindrome(halfStr, halfCnt, oddChar, n);
                }
            }
        }
        
        return "";
    }
    
    private String buildPalindrome(char[] halfStr, int[] remaining, int oddChar, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(halfStr);
        String firstHalf = sb.toString();
        if (oddChar != -1) {
            sb.append((char) ('a' + oddChar));
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}
