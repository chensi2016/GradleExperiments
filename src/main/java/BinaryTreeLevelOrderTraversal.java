import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> workList = new ArrayList<>();
        TreeNode index = root;
        workList.add(index);
        List<Integer> list = new ArrayList<>();
        TreeNode levelEndFlag = new TreeNode(0);
        workList.add(levelEndFlag);
        System.out.println("found flag");
        while ( !workList.isEmpty() ) {
            System.out.println("a new node");
            if(workList.get(0) == levelEndFlag ) {
                result.add(list);
                list = new ArrayList<>();
                workList.remove(0);
                workList.add(levelEndFlag);
                continue;
            }
            if( workList.get(0) == null ){
                workList.remove(0);
                continue;
            }
            index = workList.get(0);
            list.add(index.val);
            workList.add( index.left );
            workList.add( index.right );
            workList.remove(0);
        }
        return result;
    }
}
