import java.util.*;

class Solution {
    public int totalElements(int[] arr) {
        
        int n = arr.length;
        if (n <= 2) return n;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            while (map.size() > 2) {
                
                map.put(arr[left], map.get(arr[left]) - 1);
                
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
        
        // int n = arr.length;
        // int maxLen = 0;
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         HashSet<Integer> set = new HashSet<>();
                
        //         for (int k = i; k <= j; k++) {
        //             set.add(arr[k]);
        //         }
                
        //         if (set.size() <= 2) {
        //             maxLen = Math.max(maxLen, j - i + 1);
        //         }
        //     }
        // }
        
        // -----------------------------------------------------------------
        
        // for (int i = 0; i < n; i++) {
        //     HashMap<Integer, Integer> map = new HashMap<>();
            
        //     for (int j = i; j < n; j++) {
        //         map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                
        //         if (map.size() > 2) {
        //             break;
        //         }
                
        //         maxLen = Math.max(maxLen, j - i + 1);
        //     }
        // }
        
        // return maxLen;
    }
}
