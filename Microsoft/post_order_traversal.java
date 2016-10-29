public class Solution {
    public List<Integer> postOrderTraversal(TreeNode root) {
        
        List<Integer> res = new LinkedList<Integer>();
        
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushLeft(stack, root);
        
        TreeNode last = null;
        
        while(!stack.isEmpty()){
            TreeNode t = stack.peek();
            
            if (t.right == null || t.right == last){
                res.add(t.val);
                stack.pop();
                last = t;
            }
            else{
                pushLeft(stack, t.right);
            }
        }
        return res;
        
    }
    
    private void pushLeft(Stack<TreeNode> stack, TreeNode root){
        while (root != null){
            stack.push(root);
            System.out.println(root.val);
            root = root.left;
        }
    }
}