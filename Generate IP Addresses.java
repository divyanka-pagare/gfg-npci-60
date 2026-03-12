import java.util.*;

class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int parts, String current, ArrayList<String> result) {
        
        // If 4 parts formed and all characters used
        if (parts == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }

        // If parts exceed 4 or string finished early
        if (parts == 4 || index == s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String segment = s.substring(index, index + len);

            // Leading zero check
            if (segment.length() > 1 && segment.charAt(0) == '0') break;

            int value = Integer.parseInt(segment);
            if (value <= 255) {
                backtrack(s, index + len, parts + 1, current + segment + ".", result);
            }
        }
        
        
//         int n = s.length();

//         for (int i = 1; i <= 3; i++) {
//             for (int j = 1; j <= 3; j++) {
//                 for (int k = 1; k <= 3; k++) {

//                     int l = n - (i + j + k);

//                     if (l >= 1 && l <= 3) {

//                         String A = s.substring(0, i);
//                         String B = s.substring(i, i + j);
//                         String C = s.substring(i + j, i + j + k);
//                         String D = s.substring(i + j + k);

//                         if (valid(A) && valid(B) && valid(C) && valid(D)) {
//                             result.add(A + "." + B + "." + C + "." + D);
//                         }
//                     }
//                 }
//             }
//         }

//         return result;
//     }

//     private boolean valid(String s) {
//         if (s.length() > 1 && s.charAt(0) == '0') return false;
//         int num = Integer.parseInt(s);
//         return num >= 0 && num <= 255;
//    
    }
}
