/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue <TreeLinkNode> q = new LinkedList <> ();
        if(root!=null){
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeLinkNode t = q.peek();
            q.remove();
            if(t!=null){
                t.next = q.peek();
                
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            else if(!q.isEmpty()){
                q.add(null);
            }
        }
        }
    }
}
