public class LowestCommonAncestorRewrite {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if((right != null && left != null) ) {
            return root;
        }
        if((right != null || left != null ) && (root.val == p.val || root.val == q.val ))
        {
            return root;
        }
        if(right != null || left != null ) {
            return right == null ? left :right;
        }
        if( root.val == p.val || root.val == q.val ) {
            return root;
        } else {
            return null;
        }
    }

}
