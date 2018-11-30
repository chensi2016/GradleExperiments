import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if( n <= 0 ){
            return treeNodeList;
        }
        TreeNode firstTreeNode = new TreeNode(1);
        treeNodeList.add(firstTreeNode);
        List<TreeNode> endNodeList;
        for( int i = 2; i <= n ; i++ ) {
            TreeNode newTreeNode = new TreeNode(i);
            for (TreeNode treeNode: treeNodeList) {
               treeNodeList = dfs(treeNode, newTreeNode, treeNodeList);
            }
        }
        return treeNodeList;
    }
    List<TreeNode> dfs(TreeNode headNode, TreeNode newNode, List<TreeNode> treeNodesList) {
        TreeNode indexNode = headNode;
        TreeNode newHeadNode = new TreeNode(headNode.val);
        if( indexNode.left != null ) {
            TreeNode newLeftNode = new TreeNode(indexNode.left.val);
            newHeadNode.left = newLeftNode;
            dfs(indexNode.left, newNode,treeNodesList);
        } else {
            newHeadNode.left = newNode;
        }
        if ( indexNode.right != null ) {
            TreeNode newRightNode = new TreeNode(indexNode.right.val);
            newHeadNode.right = newRightNode;
            dfs(indexNode.right, newNode,treeNodesList);
        } else{
            newHeadNode.right = newNode;
        }

        return treeNodesList;
    }

    TreeNode copyATree(TreeNode headNode) {
        
    }
}