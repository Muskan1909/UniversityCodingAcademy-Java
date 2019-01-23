/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }
    
    private boolean isBST(TreeNode root,TreeNode l,TreeNode r){
        if(root == null)
            return true;
        
        if(l!=null && root.val <= l.val)
            return false;
        
        if(r!=null && root.val >= r.val)
            return false;
        
        return (isBST(root.left,l,root) && isBST(root.right,root,r));
    }
    
}
