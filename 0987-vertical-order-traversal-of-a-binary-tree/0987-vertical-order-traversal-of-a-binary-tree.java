/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> list of {row, value}
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0}); // node, row, col

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            if (node.left != null)
                queue.offer(new Object[]{node.left, row + 1, col - 1});

            if (node.right != null)
                queue.offer(new Object[]{node.right, row + 1, col + 1});
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            // sort by row, then value
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> colList = new ArrayList<>();
            for (int[] arr : list) {
                colList.add(arr[1]);
            }

            result.add(colList);
        }

        return result;
    }
}