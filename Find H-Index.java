class Solution {
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        int[] bucket = new int[n + 1];
        
        for (int c : citations) {
            if (c >= n) bucket[n]++;
            else bucket[c]++;
        }
        
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) return i;
        }
        return 0;
        
        // int n = citations.length;
        // int hIndex = 0;
        
        // for (int h = 0; h <= n; h++) {
        //     int count = 0;
            
        //     for (int c : citations) {
        //         if (c >= h) count++;
        //     }
        //     if (count >= h) {
        //         hIndex = h;
        //     }
        // }
        // return hIndex;
    }
}
