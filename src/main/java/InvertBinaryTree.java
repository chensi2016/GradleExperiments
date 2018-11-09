import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);

    }
    TreeNode invert(TreeNode node) {
        if( node == null ) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = invert(node.right);
        newNode.right = invert(node.left);
        return newNode;
    }
}
