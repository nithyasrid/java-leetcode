class Solution {
    class Node {
        Node[] links;
        int cnt;

        Node() {
            links = new Node[2];
            cnt = 0;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.links[bit] == null) curr.links[bit] = new Node();
                curr = curr.links[bit];
                curr.cnt++;
            }
        }

        void remove(int num) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                curr = curr.links[bit];
                curr.cnt--;
            }
        }

        int getmaxXOR(int val) {
            Node curr = root;
            int ans = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;

                if (curr.links[1 - bit] != null && curr.links[1 - bit].cnt != 0) {
                    ans |= (1 << i);
                    curr = curr.links[1 - bit];
                } 
                else curr = curr.links[bit];
            }
            return ans;
        }
    }

    public int[] res;
    public HashMap<Integer, List<int[]>> map;
    public List<List<Integer>> tree;
    public Trie t;

    public int[] maxGeneticDifference(int[] parent, int[][] q) {
        tree = new ArrayList<>();
        int n = parent.length;

        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = i;
                continue;
            }
            tree.get(parent[i]).add(i);
        }

        map = new HashMap<>();
        for (int i = 0; i < q.length; i++) {
            map.putIfAbsent(q[i][0], new ArrayList<>());
            map.get(q[i][0]).add(new int[]{q[i][1], i});
        }

        t = new Trie();
        res = new int[q.length];

        dfs(root);
        return res;
    }

    public void dfs(int root) {
        t.insert(root);

        if (map.containsKey(root)) {
            List<int[]> rootq = map.get(root);
            for (int[] qs : rootq) {
                int maxxor = t.getmaxXOR(qs[0]);
                res[qs[1]] = maxxor;
            }
        }

        for (int child : tree.get(root)) dfs(child);

        t.remove(root);
    }
}