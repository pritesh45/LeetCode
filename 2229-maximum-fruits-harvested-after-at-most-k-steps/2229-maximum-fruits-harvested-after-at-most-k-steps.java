class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int total = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            total += fruits[j][1];

            // Shrink the window from the left while steps needed exceed k
            while (i <= j) {
                int left = fruits[i][0];
                int right = fruits[j][0];

                int steps = Math.min(Math.abs(startPos - left), Math.abs(startPos - right)) + (right - left);

                if (steps <= k)
                    break;

                total -= fruits[i][1];
                i++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }
}