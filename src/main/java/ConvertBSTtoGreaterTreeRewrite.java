public class ConvertBSTtoGreaterTreeRewrite {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        return convert(root);
    }
    TreeNode convert(TreeNode root) {
        if ( root == null )
            return null;
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
        return root;
    }

}

