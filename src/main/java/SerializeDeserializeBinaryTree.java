import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if ( root == null) {
            return null;
        }
        String pre = String.valueOf(root.val) + " ";
        List<TreeNode> seriaList = new ArrayList<>();
        seriaList.add(root);
        while( !seriaList.isEmpty() ) {
            TreeNode node = seriaList.get(0);
            pre = seriaProcess(node, pre, seriaList);
        }
        return  pre;
    }
    private String seriaProcess(TreeNode startNode, String pre, List<TreeNode> seriaList) {
        String newPre;
        if(startNode.left != null) {
            newPre = pre + String.valueOf(startNode.left.val) + " ";
            seriaList.add(startNode.left);
        } else {
            newPre = pre + "L" + " ";
        }
        if(startNode.right != null) {
           newPre = newPre + String.valueOf(startNode.right.val) + " ";
           seriaList.add(startNode.right);
        } else {
            newPre = newPre + "R" + " ";
        }
        seriaList.remove(startNode);
        return newPre;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ( data == null || data.length() == 0 ) {
            return null;
        }
        String[] dataArray = data.split(" ");
        TreeNode fRoot = new TreeNode(Integer.valueOf(dataArray[0]));
        List<TreeNode> deseriaList = new ArrayList<>();
        deseriaList.add(fRoot);
        String lVal;
        String rVal;
        for ( int i = 1; i < dataArray.length - 1; i = i + 2 ) {
                lVal = dataArray[i];
                rVal = dataArray[i+1];
                deseria(lVal,rVal, deseriaList.get(0), deseriaList);
            }
        return fRoot;
    }

    private void deseria(String lVal, String rVal, TreeNode pre, List<TreeNode> deseriaList) {
            if ( !lVal.equals("L") ) {
                TreeNode lNode = new TreeNode(Integer.valueOf(lVal));
                pre.left = lNode;
                deseriaList.add(lNode);
            }
            if ( !rVal.equals("R") ) {
                TreeNode rNode = new TreeNode(Integer.valueOf(rVal));
                pre.right = rNode;
                deseriaList.add(rNode);
            }
            deseriaList.remove(pre);

            return;
    }
}
