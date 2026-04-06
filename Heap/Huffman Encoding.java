import java.util.*;

class Node {
    int freq;
    int idx;
    Node left, right;

    Node(int f, int i) {
        freq = f;
        idx = i;
    }

    Node(int f, int i, Node l, Node r) {
        freq = f;
        idx = i;
        left = l;
        right = r;
    }
}

class Solution {

    void dfs(Node root, String code, ArrayList<String> res) {
        if (root == null) return;

        // leaf node
        if (root.left == null && root.right == null) {
            if (code.length() == 0) code = "0"; // single char case
            res.add(code);
            return;
        }

        dfs(root.left, code + "0", res);
        dfs(root.right, code + "1", res);
    }

    public ArrayList<String> huffmanCodes(String s, int f[]) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq) return a.freq - b.freq;
                return a.idx - b.idx;
            }
        );

        // insert nodes
        for (int i = 0; i < s.length(); i++) {
            pq.add(new Node(f[i], i));
        }

        // build tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            int newFreq = left.freq + right.freq;

            // ---> MOST IMPORTANT FIX
            int newIndex = Math.min(left.idx, right.idx);

            Node parent = new Node(newFreq, newIndex, left, right);
            pq.add(parent);
        }

        ArrayList<String> res = new ArrayList<>();
        dfs(pq.poll(), "", res);

        return res;
    }
}
