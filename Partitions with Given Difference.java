class Solution {
    // recursion - brutforce
    
    // int count = 0;
    // public int countPartitions(int[] arr, int diff) {
    //     int totalSum = 0;
    //     for (int num : arr) totalSum += num;
    //     solve(arr, 0, 0, 0, diff);
    //     return count;
    // }
    
    // private void solve(int[] arr, int i, int sum1, int sum2, int diff) {
    //     if (i == arr.length) {
    //         if (sum1 - sum2 == diff) count++;
    //         return;
    //     }
    //     //put in S1
    //     solve(arr, i + 1, sum1 + arr[i], sum2, diff);
    //     //put in S2
    //     solve(arr, i + 1, sum1, sum2 + arr[i], diff);
    // }
//________________________________________________________________________________________

// recursion + memoization (Top-down DP)
        
//     int[][] dp;
//     int totalSum, diff;
//     int[] arr;
    
//     public int countPartitions(int[] arr, int diff) {
//         this.arr = arr;
//         this.diff = diff;
//         totalSum = 0;
//         for (int num : arr) totalSum += num;
//         if (totalSum < diff || (totalSum + diff) % 2 != 0) return 0;
//         int target = (totalSum + diff) / 2;
//         dp = new int[arr.length][target + 1];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         return solve(0, 0, target);
//     }
//     private int solve(int i, int sum, int target) {
//         if (i == arr.length) {
//             return sum == target ? 1 : 0;
//         }
//         if (dp[i][sum] != -1) return dp[i][sum];
//         int notTake = solve(i + 1, sum, target);
//         int take = 0;
//         if (sum + arr[i] <= target) {
//             take = solve(i + 1, sum + arr[i], target);
//         }
//         return dp[i][sum] = take + notTake;
//     }
// }  
//_________________________________________________________________________

// 2D DP (Tabulation)
//     public int countPartitions(int[] arr, int diff) {
//         int totalSum = 0;
//         for (int num : arr) totalSum += num;
//         if (totalSum < diff || (totalSum + diff) % 2 != 0) return 0;
//         int target = (totalSum + diff) / 2;
//         int n = arr.length;
//         int[][] dp = new int[n + 1][target + 1];
//         dp[0][0] = 1;
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= target; j++) {
//                 int notTake = dp[i - 1][j];
//                 int take = 0;
//                 if (arr[i - 1] <= j) {
//                     take = dp[i - 1][j - arr[i - 1]];
//                 }
//                 dp[i][j] = take + notTake;
//             }
//         }
//         return dp[n][target];
//     }    
// }       
        
//______________________________________________________________________________

// 1D DP (Optimal)
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        if (totalSum < diff || (totalSum + diff) % 2 != 0) return 0;
        int target = (totalSum + diff) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
