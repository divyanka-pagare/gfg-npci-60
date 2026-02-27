class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;

        // Step 1: Create prefix sum matrix
        int[][] prefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                prefix[i][j] = mat[i][j];

                if (i > 0)
                    prefix[i][j] += prefix[i - 1][j];

                if (j > 0)
                    prefix[i][j] += prefix[i][j - 1];

                if (i > 0 && j > 0)
                    prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        // Step 2: Try all square sizes
        for (int size = 1; size <= Math.min(n, m); size++) {

            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= m; j++) {

                    int r1 = i;
                    int c1 = j;
                    int r2 = i + size - 1;
                    int c2 = j + size - 1;

                    int sum = prefix[r2][c2];

                    if (r1 > 0)
                        sum -= prefix[r1 - 1][c2];

                    if (c1 > 0)
                        sum -= prefix[r2][c1 - 1];

                    if (r1 > 0 && c1 > 0)
                        sum += prefix[r1 - 1][c1 - 1];

                    if (sum == x)
                        count++;
                }
            }
        }

        return count;
        
        
        // int n = mat.length;
        // int m = mat[0].length;
        // int count = 0;

        // // Try all possible square sizes
        // for (int size = 1; size <= Math.min(n, m); size++) {

        //     // Try all possible top-left corners
        //     for (int i = 0; i + size <= n; i++) {
        //         for (int j = 0; j + size <= m; j++) {

        //             int sum = 0;

        //             // Calculate sum of current square
        //             for (int r = i; r < i + size; r++) {
        //                 for (int c = j; c < j + size; c++) {
        //                     sum += mat[r][c];
        //                 }
        //             }

        //             if (sum == x) {
        //                 count++;
        //             }
        //         }
        //     }
        // }

        // return count;
    }
}
