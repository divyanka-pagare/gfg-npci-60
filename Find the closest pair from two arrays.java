class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = m - 1;
        int minDiff = Integer.MAX_VALUE;
        int a = 0, b = 0;
        
        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);
            
            if (diff < minDiff) {
                minDiff = diff;
                a = arr1[i];
                b = arr2[j];
            }
            
            if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        
        return result;
        
        
        // int n = arr1.length;
        // int m = arr2.length;
        // int minDiff = Integer.MAX_VALUE;
        // int a = 0, b = 0;
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         int sum = arr1[i] + arr2[j];
        //         int diff = Math.abs(sum - x);
                
        //         if (diff < minDiff) {
        //             minDiff = diff;
        //             a = arr1[i];
        //             b = arr2[j];
        //         }
        //     }
        // }
        
        // ArrayList<Integer> result = new ArrayList<>();
        // result.add(a);
        // result.add(b);
        // return result;
    }
}
