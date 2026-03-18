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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        long maxWidth = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIndex = queue.peek().index; // normalize

            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();

                long idx = curr.index - minIndex; // avoid overflow
                TreeNode node = curr.node;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * idx));

                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * idx + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return (int) maxWidth;
    }

    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
}