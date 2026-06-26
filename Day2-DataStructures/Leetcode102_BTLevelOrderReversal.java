//Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level).
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]

import java.util.*;

public class Leetcode102_BTLevelOrderReversal {

    // TreeNode Definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> levelValues = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode elem = queue.poll();
                levelValues.add(elem.val);

                if (elem.left !=null)
                    queue.offer(elem.left);

                if (elem.right !=null)
                    queue.offer(elem.right);
            }
            ans.add(levelValues);
        }
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Leetcode102_BTLevelOrderReversal solution =new Leetcode102_BTLevelOrderReversal();
                
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println(result);
    }
}