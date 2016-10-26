/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        /*
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
        */
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == null || r == null){
                if(l != r) return false;
            }
            else{
                if (l.val != r.val) return false;
                else{
                    q.add(l.left);
                    q.add(r.right);
                    q.add(l.right);
                    q.add(r.left);
                }
            }
        }
        return true;
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        else{
            if (left.val == right.val) 
                return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
            else return false;
        }
    }
}