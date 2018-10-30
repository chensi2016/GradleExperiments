import org.junit.Test;

import static org.junit.Assert.*;

public class SerializeDeserializeBinaryTreeTest {
    SerializeDeserializeBinaryTree seriaDeseria = new SerializeDeserializeBinaryTree();
    TreeNode root = new TreeNode(-1);
    TreeNode a = new TreeNode(0);
    TreeNode b = new TreeNode(1);
    //TreeNode c = new TreeNode(4);
    //TreeNode d = new TreeNode(5);
    String data = "123LR45LRLR";
    @Test
     public void deserialize() {
        root.left = a;
        root.right = b;
        //b.left = c;
        //b.right = d;
        assertEquals(seriaDeseria.deserialize(seriaDeseria.serialize(root)).val, root.val);
    }


  /* public void serialize() {
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        assertEquals(seriaDeseria.serialize(root),data);

    }
    */
}