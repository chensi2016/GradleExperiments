public class HouseRobber3 {
    public int rob(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = rob(root.left);
        int right = rob(root.right);
        int leftLeft = 0;
        int leftRight = 0;
        if(root.left != null ) {
        leftLeft = rob(root.left.left);
            leftRight = rob(root.right.right);
        }
        int rightLeft = 0;
        int rightRight = 0;
        if(root.right != null ) {
           rightLeft = rob(root.right.left);
           rightRight = rob(root.right.right);
        }

        return Math.max(root.val + leftLeft + leftRight + rightLeft + rightRight, left + right);
    }

}
