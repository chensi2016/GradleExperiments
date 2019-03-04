import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalTest {

    BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = left2;
        right.right = right2;
        assertEquals(3, binaryTreeLevelOrderTraversal.levelOrder(root).size());
    }
}