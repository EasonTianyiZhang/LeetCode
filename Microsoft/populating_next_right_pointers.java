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
        TreeLinkNode  head = root;
        
        while(head != null){
            TreeLinkNode pre = null;
            TreeLinkNode curr = head;
            head = null;
            
            while(curr!= null){
                if (curr.left != null){
                    if (pre == null)
                        head = curr.left;
                    else
                        pre.next = curr.left;
            
                    pre = curr.left;
                }
                if (curr.right != null){
                    if (pre == null)
                        head = curr.right;
                    else
                        pre.next = curr.right;
        
                    pre = curr.right;
                }
                curr = curr.next;
            }
        }
        return;
    }
}