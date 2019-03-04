public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root != null ) {
            flatten(root.left);
            flatten(root.right);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode index = root;
            while (index != null) {
                index = index.right;
            }
            index.right = temp;
        }
    }
}
