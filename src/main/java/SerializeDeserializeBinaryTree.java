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
    private List<TreeNode> seriaList = new ArrayList<>();
    private TreeNode fRoot;
    private List<TreeNode> deseriaList = new ArrayList<>();

    public String serialize(TreeNode root) {
        if ( root == null) {
            return null;
        }
        String pre = String.valueOf(root.val) + " ";
        seriaList.add(root);
        while( !seriaList.isEmpty() ) {
            TreeNode node = seriaList.get(0);
            pre = seriaProcess(node, pre);
        }
        return  pre;
    }
    private String seriaProcess(TreeNode startNode, String pre) {
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
        int beginIndex = 0;
        int endIndex = 0;

        while( endIndex < data.length() ) {
            if ( data.charAt(endIndex) == ' ' ) {
                break;
            }
            endIndex++;
        }
        fRoot = new TreeNode(Integer.valueOf(data.substring(beginIndex, endIndex)));
        deseriaList.add(fRoot);
        endIndex++;
        beginIndex = endIndex;
        int count = 0;
        String lVal = "";
        String rVal = "";
        while( endIndex < data.length() ) {

            if(data.charAt(endIndex) == ' ' && count == 0) {
                lVal = data.substring(beginIndex, endIndex);
                beginIndex = endIndex + 1;
                count = 1;
                endIndex++;
                continue;
            }
            if(data.charAt(endIndex) == ' ' && count == 1) {
                rVal = data.substring(beginIndex, endIndex);
                beginIndex = endIndex + 1;
                count = 0;
                deseria(lVal,rVal, deseriaList.get(0));
            }
            endIndex++;
        }
        return fRoot;
    }

    private void deseria(String lVal, String rVal, TreeNode pre) {
            if ( !lVal.equals("L")) {
                TreeNode lNode = new TreeNode(Integer.valueOf(lVal));
                pre.left = lNode;
                deseriaList.add(lNode);
            }if ( !rVal.equals("R") ) {
                TreeNode rNode = new TreeNode(Integer.valueOf(rVal));
                pre.right = rNode;
                deseriaList.add(rNode);
            }
            deseriaList.remove(pre);

            return;
    }
}
