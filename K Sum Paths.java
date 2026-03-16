/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count = 0;
    public int countAllPaths(Node root, int k) {
        
    //     if (root == null) return 0;
    //     findPaths(root, k);
    //     countAllPaths(root.left, k);
    //     countAllPaths(root.right, k);
            
    //     return count;
    // }
    // void findPaths(Node node, long k) {
    //     if (node == null) return;
    //     if (node.data == k)
    //         count++;
                
    //     findPaths(node.left, k - node.data);
    //     findPaths(node.right, k - node.data);
    
    HashMap<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);
    dfs(root, 0, k, map);
    return count;
    }
    
    void dfs(Node node, long currSum, int k, HashMap<Long, Integer> map) {
        if (node == null) return;
        currSum += node.data;
        if (map.containsKey(currSum - k))
            count += map.get(currSum - k);
            
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        dfs(node.left, currSum, k, map);
        dfs(node.right, currSum, k, map);
        
        map.put(currSum, map.get(currSum) - 1);
    }
}
