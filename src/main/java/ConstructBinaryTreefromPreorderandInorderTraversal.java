import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder,0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    TreeNode buildTree(int[] preorder, int preFrom, int preEnd, int[] inorder, int inFrom, int inEnd, Map map) {
        while( preFrom > preEnd){
            return null;
        }
        int parentofInorder = (int)map.get(preorder[preFrom]);
        TreeNode parent = new TreeNode(preorder[preFrom]);
        int leftPreFrom = preFrom + 1;
        int leftPreEnd = (parentofInorder-inFrom)+preFrom;
        int leftInFrom = inFrom;
        int leftInEnd = parentofInorder-1;
        parent.left = buildTree(preorder, leftPreFrom, leftPreEnd, inorder, leftInFrom, leftInEnd, map);

        int rightPreFrom = leftPreEnd+1;
        int rightPreEnd = preEnd;
        int rightInFrom = parentofInorder + 1;
        int rightInEnd = inEnd;
        parent.right = buildTree(preorder, rightPreFrom, rightPreEnd, inorder, rightInFrom, rightInEnd, map);
        return parent;
    }
}
