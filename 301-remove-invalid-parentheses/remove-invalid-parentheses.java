class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, 0, 0, new char[]{'(', ')'}, ans);
        return ans;
    }

    private void remove(String s, int start, int last, char[] par, List<String> ans) {
        int balance = 0;

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) balance++;
            if (s.charAt(i) == par[1]) balance--;

            if (balance >= 0) continue;

            for (int j = last; j <= i; j++) {
                if (s.charAt(j) == par[1] &&
                    (j == last || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1),
                           i, j, par, ans);
                }
            }

            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();

        if (par[0] == '(') {
            remove(reversed, 0, 0, new char[]{')', '('}, ans);
        } else {
            ans.add(reversed);
        }
    }
}