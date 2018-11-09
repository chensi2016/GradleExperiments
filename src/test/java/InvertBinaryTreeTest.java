import org.junit.Test;

import static org.junit.Assert.*;

public class InvertBinaryTreeTest {
    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root = invertBinaryTree.invertTree(root);
        assertEquals(4,root.val);

    }
}