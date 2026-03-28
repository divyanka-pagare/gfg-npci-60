class Solution {
    static int timer;
    static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] tin, int[] low, boolean[] isAP) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        int children = 0;
        for (int neigh : adj.get(node)) {
            if (neigh == parent) continue;
            if (!vis[neigh]) {
                dfs(neigh, node, adj, vis, tin, low, isAP);
                low[node] = Math.min(low[node], low[neigh]);
                
                //articulation condition
                if (low[neigh] >= tin[node] && parent != -1) {
                    isAP[node] = true;
                }
                children++;
            } else {
                // back page
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }
        //root node condition
        if (parent == -1 && children > 1) {
            isAP[node] = true;
        }
    }
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        timer = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i , -1, adj, vis, tin, low, isAP);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) res.add(i);
        }
        if (res.size() == 0) {
            res.add(-1);
        }
        return res;
    }
}  
