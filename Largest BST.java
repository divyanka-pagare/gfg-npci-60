/*
You're given a binary tree. Your task is to find the size of the largest subtree within this binary tree that also satisfies the properties of a Binary Search Tree (BST). The size of a subtree is defined as the number of nodes it contains.

Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less than the node, and the right child is greater than the node, without any duplicate values in the subtree.

Examples :

Input: root = [5, 2, 4, 1, 3]
Root-to-leaf-path-sum-equal-to-a-given-number-copy
Output: 3
Explanation:The following sub-tree is a BST of size 3
Balance-a-Binary-Search-Tree-3-copy
Input: root = [6, 7, 3, N, 2, 2, 4]

Output: 3
Explanation: The following sub-tree is a BST of size 3:

Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
*/

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        
        Info (boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
    static int largestBst(Node root) {
        return solve(root).size;
    }
    static Info solve(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            
            return new Info(true, size, min, max);
        }
        
        return new Info(false, Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Return the size of the largest sub-tree which is also a BST
    // static int largestBst(Node root) {
    //     if (root == null) return 0;
    //     if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
    //         return countNodes(root);
    //     }
        
    //     return Math.max(largestBst(root.left), largestBst(root.right));
        
    // }
    
    // static boolean isBST(Node root, int min, int max) {
    //     if (root == null) return true;
        
    //     if (root.data <= min || root.data >= max) return false;
        
    //     return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    // }
    
    // static int countNodes(Node root) {
    //     if (root == null) return 0;
    //     return 1 + countNodes(root.left) + countNodes(root.right);
    // }
}
