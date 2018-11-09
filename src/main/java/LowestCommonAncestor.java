public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if(right != null || left != null) {
            return right== null ? left : right;
        }
        if(lookforX(root,p) && lookforX(root, q)) {
            return root;
        } else {
            return null;
        }
    }
    boolean lookforX(TreeNode node, TreeNode x) {
        if(node == null){
            return false;
        }
        if( node.val == x.val) {
            return true;
        } else {
            if (lookforX(node.left, x) ) {
                return true;
            } if (lookforX(node.right, x) ) {
                return true;
            }
        }
        return false;
    }

}
