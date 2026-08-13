class Solution {

    class Node {
        char leftChar, rightChar;
        int leftLen, rightLen, maxLen, len;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            leftLen = 1;
            rightLen = 1;
            maxLen = 1;
            len = 1;
        }
    }

    Node[] tree;
    String s;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        this.s = s;

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );

            ans[i] = tree[1].maxLen;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {

        Node res = new Node(a.leftChar);

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.leftLen = a.leftLen;
        res.rightLen = b.rightLen;

        res.maxLen = Math.max(a.maxLen, b.maxLen);

        // If boundary characters are same, they can be joined
        if (a.rightChar == b.leftChar) {

            res.maxLen = Math.max(
                res.maxLen,
                a.rightLen + b.leftLen
            );

            // Entire left segment has same character
            if (a.leftLen == a.len) {
                res.leftLen = a.len + b.leftLen;
            }

            // Entire right segment has same character
            if (b.rightLen == b.len) {
                res.rightLen = b.len + a.rightLen;
            }
        }

        return res;
    }

    void update(int node, int l, int r, int index, char c) {

        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
}