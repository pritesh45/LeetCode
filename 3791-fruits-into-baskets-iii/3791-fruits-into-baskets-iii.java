class Solution {
    int[] seg;

    void build(int[] baskets, int i, int l, int r) {
        if (l == r) {
            seg[i] = baskets[l];
            return;
        }
        int mid = (l + r) / 2;
        build(baskets, 2 * i + 1, l, mid);
        build(baskets, 2 * i + 2, mid + 1, r);
        seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
    }

    boolean query(int i, int l, int r, int val) {
        if (seg[i] < val)
            return false;
        if (l == r) {
            seg[i] = -1;
            return true;
        }
        int mid = (l + r) / 2;
        boolean placed;
        if (seg[2 * i + 1] >= val)
            placed = query(2 * i + 1, l, mid, val);
        else
            placed = query(2 * i + 2, mid + 1, r, val);
        seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
        return placed;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        seg = new int[4 * n];
        Arrays.fill(seg, -1);
        build(baskets, 0, 0, n - 1);
        int ans = 0;
        for (int fruit : fruits)
            if (!query(0, 0, n - 1, fruit))
                ans++;
        return ans;
    }
}
