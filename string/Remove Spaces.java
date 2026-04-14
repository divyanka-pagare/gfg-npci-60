// import java.util.stream.Collectors;

class Solution {
    String removeSpaces(String s) {
        
    // StringBuilder --> time 0.06 (priority)
    // 1. More control
    // 2. efficient when doing custom filtering
    // 3. avoids multiple string creations
    
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                result.append(ch);
            }
        }
        return result.toString();
        
// --------------------------------------------------------------------
  
    // replace --> time 0.06 (priority)
    // 1. very clean & readable
    // 2. Internally optimized
    // 3. time and space complexity -> O(n)
    
        // return s.replace(" ", ""); 
        
// --------------------------------------------------------------------

//In-Place Using Char Array --> time 0.06 (best for optimization discussion)
    // 1. No extra StringBuilder
    // 2. Reuse same array
    // tc -> O(n), sc -> O(n) , due to char array, but optimized internally
    
        // char[] arr = s.toCharArray();
        // int index = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] != ' ') {
        //         arr[index++] = arr[i];
        //     }
        // }
        // return new String(arr, 0, index);
        
// ---------------------------------------------------------------

// Using Java Streams --> time 0.12 
    // it is functional programming style
    // not preferred in interviews (less readable + overhead)
    
        // return s.chars()
        //         .filter(c -> c != ' ')
        //         .mapToObj(c -> String.valueOf((char) c))
        //         .collect(Collectors.joining());
        
// ----------------------------------------------------------------

    // toCharArray() --> time 0.05
    
        // char[] arr = s.toCharArray();
        // StringBuilder result = new StringBuilder();
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] != ' ') {
        //         result.append(arr[i]);
        //     }
        // }
        // return result.toString();
        
    }
}
