class DSU {
    int[] parent, size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    boolean isConnected(int a, int b) {
        return findParent(a) == findParent(b);
    }

    void union_by_size(int a, int b) {
        int par_a = findParent(a);
        int par_b = findParent(b);

        if (par_a == par_b) {
            return;
        }

        if (size[par_a] >= size[par_b]) {
            size[par_a] += size[par_b];
            parent[par_b] = par_a;
        } else if (size[par_a] < size[par_b]) {
            size[par_b] += size[par_a];
            parent[par_a] = par_b;
        }
    }
}

class Solution {

    int findMSTusingKruskal(
            int n,
            int[][] indexed_edges,
            int removed_edge_index,
            int again_added_edge_index) {

        DSU dsu = new DSU(n);

        // Traverse through all the edges, and connect them if not connected,
        // ensuring no cycles form
        int MST_wt = 0;
        int edges_used = 0;

        // Use that specified edge first
        if (again_added_edge_index != -1) {
            for (int[] edge : indexed_edges) {
                int wt = edge[0];
                int a = edge[1];
                int b = edge[2];
                int idx = edge[3];

                if (idx == again_added_edge_index) {
                    dsu.union_by_size(a, b);
                    MST_wt += wt;
                    edges_used++;
                    break;
                }
            }
        }

        for (int[] edge : indexed_edges) {
            int wt = edge[0];
            int a = edge[1];
            int b = edge[2];
            int idx = edge[3];

            if (idx == removed_edge_index ||
                idx == again_added_edge_index) {
                continue;
            }

            if (!dsu.isConnected(a, b)) {
                dsu.union_by_size(a, b);
                MST_wt += wt;
                edges_used++;
            }
        }

        if (edges_used != n - 1) {
            return Integer.MAX_VALUE;
        }

        return MST_wt;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
            int n, int[][] edges) {

        // 1. Store the edges along with their respective index
        // { weight, a, b, index }
        int[][] indexed_edges = new int[edges.length][4];

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int wt = edges[i][2];

            indexed_edges[i] = new int[]{wt, a, b, i};
        }

        Arrays.sort(indexed_edges, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            }
            if (x[2] != y[2]) {
                return Integer.compare(x[2], y[2]);
            }
            return Integer.compare(x[3], y[3]);
        });

        // 2. Using Kruskal's Algorithm find MST
        // Sort acc. to weights
        int MST_wt =
                findMSTusingKruskal(n, indexed_edges, -1, -1);

        // 3. Check for each edge id it is Crtical or Pseudo Critical.
        List<List<Integer>> ans_edges = new ArrayList<>();
        ans_edges.add(new ArrayList<>());
        ans_edges.add(new ArrayList<>());

        for (int[] edge : indexed_edges) {
            int wt = edge[0];
            int a = edge[1];
            int b = edge[2];
            int idx = edge[3];

            // If after removing cur edge, MST_wt increases or impossible
            // => it must be present in all the possible MSTs
            // => It is a Critical edge

            // Remove current edge
            int MST_without_cur_edge =
                    findMSTusingKruskal(n, indexed_edges, idx, -1);

            if (MST_without_cur_edge > MST_wt) {
                ans_edges.get(0).add(idx);
            }

            // If after again adding cur edge, MST_wt remains the same
            // => it can be present in some of the possible MSTs
            // => It is a Pseudo-Critical edge
            else {
                int MST_with_cur_edge =
                        findMSTusingKruskal(n, indexed_edges, -1, idx);

                if (MST_with_cur_edge == MST_wt) {
                    ans_edges.get(1).add(idx);
                }
            }
        }

        return ans_edges;
    }
}