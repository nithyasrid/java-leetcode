class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {

        int n = nums.length;
        int m = queries.length;

        Arrays.sort(nums);

        int[][] newQueries = new int[m][3];

        for(int i = 0; i < m; i++){
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }

        Arrays.sort(newQueries, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            ans[i] = -1;
        }

        int idx = 0;
        Node root = new Node();

        for(int i = 0; i < m; i++){

            int max = newQueries[i][1];

            while(idx < n && nums[idx] <= max){
                insert(root, nums[idx++]);
            }

            if(idx > 0){
                ans[newQueries[i][2]] = getMaxXor(root, newQueries[i][0]);
            }
        }

        return ans;
    }

    public int getMaxXor(Node root, int num){

        int xor = 0;

        for(int i = 30; i >= 0; i--){

            int bit = (num >> i) & 1;

            if(bit == 0){

                if(root.right != null){
                    root = root.right;
                    xor = (xor << 1) | 1;
                }else{
                    root = root.left;
                    xor <<= 1;
                }

            }else{

                if(root.left != null){
                    root = root.left;
                    xor = (xor << 1) | 1;
                }else{
                    root = root.right;
                    xor <<= 1;
                }
            }
        }

        return xor;
    }

    public void insert(Node root, int num){

        for(int i = 30; i >= 0; i--){

            int bit = (num >> i) & 1;

            if(bit == 0){

                if(root.left == null){
                    root.left = new Node();
                }
                root = root.left;

            }else{

                if(root.right == null){
                    root.right = new Node();
                }
                root = root.right;
            }
        }
    }

    class Node{
        Node left;
        Node right;
    }
}