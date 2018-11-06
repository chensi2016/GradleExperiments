public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
                return convert(root, 0);
            }
            TreeNode convert(TreeNode root, int plus) {
                if ( root == null )
                    return null;
                int newPlus;
                if ( root.right != null) {
                    root.val = root.val + getSum(root.right) + plus;
                    convert(root.right, plus);

                } else {
                    root.val = root.val + plus;
                }
                if ( root.left != null) {
                    newPlus = root.val;
                    convert(root.left, newPlus);
                }
                return root;

            }

            int getSum(TreeNode node) {
                int result = node.val;
                if ( node.left != null ) {
                    result += getSum(node.left);
                }
                if (node.right != null) {
                    result += getSum(node.right);
                }
                return result;

            }

        }
