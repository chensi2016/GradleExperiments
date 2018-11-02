public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if ( t1 == null && t2 == null )
            return null;
        if ( t1 == null || t2 == null)
            return t1==null?t2:t1;

        return merge(t1,t2);
    }
    TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return null;
        if (node1 == null || node2 == null)
            return node1 == null ? node2 : node1;
        TreeNode mergedTree = new TreeNode(node1.val+node2.val);
        mergedTree.left = merge(node1.left,node2.left);
        mergedTree.right = merge(node1.right, node2.right);
        return mergedTree;
    }
}
