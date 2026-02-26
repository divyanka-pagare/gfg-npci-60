class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
        if (s1.length() != s2.length()) return false;
        
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            // If not mapped yet
            if (map1[c1 - 'a'] == 0 && map2[c2 - 'a'] == 0) {
                map1[c1 - 'a'] = c2;
                map2[c2 - 'a'] = c1;
            }
            
            // If mapping mismatch
            else if (map1[c1 - 'a'] != c2) {
                return false;
            }
        }
        
        return true;
        
        
        // if (s1.length() != s2.length()) return false;
        
        // int n = s1.length();
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
                
        //         // If characters in s1 are same,
        //         // then characters in s2 must also be same
        //         if (s1.charAt(i) == s1.charAt(j) && 
        //             s2.charAt(i) != s2.charAt(j)) {
        //             return false;
        //         }
                
        //         // If characters in s1 are different,
        //         // then characters in s2 must also be different
        //         if (s1.charAt(i) != s1.charAt(j) && 
        //             s2.charAt(i) == s2.charAt(j)) {
        //             return false;
        //         }
        //     }
        // }
        
        // return true;
    
    }
}
