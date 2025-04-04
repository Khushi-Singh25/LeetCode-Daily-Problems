class Pair{
    TreeNode node; int ht;
    Pair(TreeNode node, int ht){
        this.node = node;
        this.ht = ht;
    }
}
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair lca = findLCA(root);
        return lca.node;
    }

    public Pair findLCA(TreeNode root){
        if(root==null){
            return new Pair(null, 0);
        }
        Pair lh = findLCA(root.left);
        Pair rh = findLCA(root.right);
        if(lh.ht == rh.ht){
            return new Pair(root, 1+lh.ht);
        }else if(lh.ht > rh.ht){
            return new Pair(lh.node, 1+lh.ht);
        }
        return new Pair(rh.node, 1+rh.ht);
    }
} 