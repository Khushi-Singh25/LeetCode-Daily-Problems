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
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        for(int i=0; i<n; i++){
            map.put(post[i], i);
        }
        return rec(0, n-1, 0, n-1, pre, post);
    }

    public TreeNode rec(int preS, int preE, int postS, int postE, int[] pre, int[] post){
        if(preS>preE || postS>postE){
            return null;
        }
        TreeNode root = new TreeNode(pre[preS]);
        if(preS == preE) return root;
        int r = map.get(pre[preS+1]);
        int size = r - postS + 1;
        root.left = rec(preS+1, preS+size, postS, postS+size-1, pre, post);
        root.right = rec(preS+size+1, preE, r+1, postE-1, pre, post);
        return root;
    }
}