
class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
    private Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') level++;
            else if (c == '}') level--;
            else if (c == ',' && level == 0) {
                result.addAll(solve(s.substring(0, i)));
                result.addAll(solve(s.substring(i + 1)));
                return result;
            }
        }
        result.add("");
        for (int i = 0; i < s.length();) {

            Set<String> part = new HashSet<>();

            if (s.charAt(i) == '{') {
                int start = i;
                int level2 = 0;

                while (i < s.length()) {
                    if (s.charAt(i) == '{') level2++;
                    else if (s.charAt(i) == '}') level2--;

                    if (level2 == 0) break;
                    i++;
                }

                part = solve(s.substring(start + 1, i));
                i++;
            } 
            else {
                part.add(String.valueOf(s.charAt(i)));
                i++;
            }

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : part) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }
}