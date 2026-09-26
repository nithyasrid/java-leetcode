class Solution {

    class Node {
        Node[] children = new Node[26];
        List<String> products = new ArrayList<>();
    }

    Node root = new Node();

    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int ch = word.charAt(i) - 'a';

            if (curr.children[ch] == null) {
                curr.children[ch] = new Node();
            }

            curr = curr.children[ch];

            if (curr.products.size() < 3) {
                curr.products.add(word);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products,String searchWord) {

        Arrays.sort(products);
        // insert all prod
        for (String product : products) {
            insert(product);
        }
        List<List<String>> ans = new ArrayList<>();

        Node curr = root;
        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (curr != null && curr.children[index] != null) {
                curr = curr.children[index];
                ans.add(curr.products);
            } else {
                curr = null;
                ans.add(new ArrayList<>());
            }
        }
        return ans;
    }
}