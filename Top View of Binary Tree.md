To solve Top View of Binary Tree optimally, we use Level Order Traversal (BFS) with Horizontal Distance (HD).

Key Idea

Assign horizontal distance (HD) to each node.

Root → HD = 0

Left child → HD - 1

Right child → HD + 1

While doing BFS, store the first node encountered for each HD (because it is the topmost node).

Use a TreeMap to keep keys sorted from leftmost to rightmost.

Why BFS?

BFS processes nodes level by level, ensuring the first node we see at a horizontal distance is the topmost.

Time & Space Complexity

Time: O(N log N) (due to TreeMap insertion)

Space: O(N)

---------------------------------------------------------------------------
Even More Optimized (O(N)) Idea

Instead of TreeMap, use:

HashMap

Track minHD and maxHD

Then iterate from minHD → maxHD.

This avoids logN cost.

You can achieve O(N) time by avoiding TreeMap.
Instead, use a HashMap + track min and max horizontal distance (HD) during BFS.

Idea

Root → HD = 0

Left child → HD - 1

Right child → HD + 1

Use BFS so the first node seen at each HD is the topmost node.

Store the first occurrence in a HashMap.

Track minHD and maxHD to print result from left → right.

Time & Space Complexity

Time: O(N)

Space: O(N)

Why This Is Better

HashMap lookup → O(1)

No sorting required

BFS guarantees topmost nodes are stored first

Quick Visualization

Example tree

        1
       / \
      2   3

Horizontal distances

2 (-1)   1 (0)   3 (1)

Top View →

[2, 1, 3]
