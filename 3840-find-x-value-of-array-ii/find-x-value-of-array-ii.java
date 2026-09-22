class Solution {

    int k;

    class Node {
        int prod;
        int[] cnt;

        Node() {
            cnt = new int[k];
        }
    }

    Node merge(Node left, Node right) {

        Node res = new Node();

        res.prod = (int)((long)left.prod * right.prod % k);

        
        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }

        
        for (int r = 0; r < k; r++) {
            int newRem = (int)((long)left.prod * r % k);
            res.cnt[newRem] += right.cnt[r];
        }

        return res;
    }

    void build(Node[] tree, int node, int l, int r, int[] nums) {

        if (l == r) {
            tree[node] = new Node();

            int rem = nums[l] % k;

            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(tree, node * 2, l, mid, nums);
        build(tree, node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(Node[] tree, int node, int l, int r,
                int index, int value) {

        if (l == r) {

            int rem = value % k;

            tree[node] = new Node();
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(tree, node * 2, l, mid, index, value);
        } else {
            update(tree, node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(Node[] tree, int node, int l, int r,
               int ql, int qr) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(tree, node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(tree, node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(tree, node * 2, l, mid, ql, qr);
        Node right = query(tree, node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        Node[] tree = new Node[4 * n];

        build(tree, 1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(tree, 1, 0, n - 1, index, value);

            
            Node res = query(tree, 1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }
}