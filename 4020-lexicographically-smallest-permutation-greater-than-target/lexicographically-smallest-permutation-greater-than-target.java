class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        char[] result = new char[n];
        int matched = 0;
        for (int i = 0; i < n; i++) {
            int idx = target.charAt(i) - 'a';
            if (counts[idx] > 0) {
                result[i] = target.charAt(i);
                counts[idx]--;
                matched++;
            } else {
                break;
            }
        }
        
        for (int i = matched; i >= 0; i--) {
            if (i < matched) {
                counts[result[i] - 'a']++;
            }
            if (i == n) {
                continue;
            }
            int targetIdx = target.charAt(i) - 'a';
            for (int c = targetIdx + 1; c < 26; c++) {
                if (counts[c] > 0) {
                    result[i] = (char) ('a' + c);
                    counts[c]--;
                    int ptr = i + 1;
                    for (int j = 0; j < 26; j++) {
                        while (counts[j] > 0) {
                            result[ptr++] = (char) ('a' + j);
                            counts[j]--;
                        }
                    }
                    return new String(result);
                }
            }
        }
        return "";
    }
}
