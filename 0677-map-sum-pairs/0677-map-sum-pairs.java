class TrieNode {
    TrieNode[] child = new TrieNode[26];
    int sum = 0; // Store the sum of values of all strings go through this node.
}

class MapSum { // 10 ms, faster than 100.00%
    HashMap<String, Integer> map = new HashMap<>();
    TrieNode trieRoot = new TrieNode();

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        TrieNode curr = trieRoot;
        for (char c : key.toCharArray()) {
            c -= 'a';
            if (curr.child[c] == null) curr.child[c] = new TrieNode();
            curr = curr.child[c];
            curr.sum += diff;
        }
        map.put(key, val);
    }
    public int sum(String prefix) {
        TrieNode curr = trieRoot;
        for (char c : prefix.toCharArray()) {
            c -= 'a';
            if (curr.child[c] == null) return 0;
            curr = curr.child[c];
        }
        return curr.sum;
    }
}