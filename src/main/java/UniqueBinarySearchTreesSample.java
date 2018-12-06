import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesSample {
        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) return new ArrayList<TreeNode>();
            return generateSubTree(1, n);
        }
        public ArrayList<TreeNode> generateSubTree(int start, int end) {
            ArrayList<TreeNode> result = new ArrayList<TreeNode>();
            if (start > end) {
                result.add(null);
                return result;
            }
            for (int rootVal = start; rootVal <= end; rootVal++)
                for (TreeNode leftSubTreeRoot : generateSubTree(start, rootVal - 1))
                    for (TreeNode rightSubTreeRoot : generateSubTree(rootVal + 1, end)) {
                        TreeNode root = new TreeNode(rootVal);
                        root.left = leftSubTreeRoot;
                        root.right = rightSubTreeRoot;
                        result.add(root);
                    }
            return result;
        }

    }