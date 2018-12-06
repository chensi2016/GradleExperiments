import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(n,0);
    }

    public List<TreeNode> generateTreesHelper(int n, int plus) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if ( n == 1 ) {
            TreeNode node = new TreeNode(n + plus);
            treeNodeList.add(node);
            return treeNodeList;
        }
        if ( n > 1 ) {
            for (TreeNode rightNode : generateTreesHelper(n-1,plus) ) {
                TreeNode headNode = new TreeNode(n + plus);
                headNode.right = rightNode;
                treeNodeList.add(headNode);
            }
            for ( int i = 1; i <= n-2; i++ ) {
                for ( TreeNode leftNode : generateTreesHelper(i, plus)) {
                    for ( TreeNode rightNode : generateTreesHelper(n-1-i, plus + i) ) {
                        TreeNode headNode = new TreeNode(n + plus);
                        headNode.left = leftNode;
                        headNode.right = rightNode;
                        treeNodeList.add(headNode);
                    }
                }
            }
            for (TreeNode leftNode : generateTreesHelper(n-1,plus) ) {
                TreeNode headNode = new TreeNode(n + plus);
                headNode.left = leftNode;
                treeNodeList.add(headNode);
            }
        }
        return treeNodeList;
    }


}