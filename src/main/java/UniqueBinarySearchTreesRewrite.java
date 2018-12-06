import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesRewrite {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(n,0);
    }
    public List<TreeNode> generateTreesHelper(int n, int plus) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if ( n == 0 ) {
            treeNodeList.add(null);
            return treeNodeList;
        }
       if ( n == 1 ) {
            TreeNode node = new TreeNode(n + plus);
            treeNodeList.add(node);
            return treeNodeList;
        }
        if ( n >=2 ) {
            for (int i = 1; i <= n ; i++) {
                for (TreeNode leftNode : generateTreesHelper(i - 1, plus)) {
                    for (TreeNode rightNode : generateTreesHelper(n - i, plus + i)) {
                        TreeNode headNode = new TreeNode(i + plus);
                        headNode.left = leftNode;
                        headNode.right = rightNode;
                        treeNodeList.add(headNode);
                    }

                }
            }
        }
        return treeNodeList;
    }
}
