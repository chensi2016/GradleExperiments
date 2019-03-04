
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] matrix = new boolean[numCourses];
        List<List<Integer>> list = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for( int i = 0; i < prerequisites.length; i++ ){
           list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] canFinish = new int[numCourses];
        for( int i= 0; i < numCourses; i++ ){
            if(dfs(list, canFinish, matrix, i)){
                canFinish[i] = 2;
            }else{
                canFinish[i] = 1;
            }

            if(canFinish[i] == 1){
                return false;
            }
            Arrays.fill(matrix, false);
        }
        return true;
    }
    boolean dfs(List<List<Integer>> list,int[] canFinish, boolean[] matrix, int num){
        if(canFinish[num] == 1){
            return false;
        }else if(canFinish[num] == 2){
            return true;
        }else {
            if (matrix[num] == true) {
                return false;
            } else {
                matrix[num] = true;
                for (int x : list.get(num)) {
                    System.out.println("x: " + x + " matrix[x] = " + matrix[x]);
                    boolean sign = dfs(list, canFinish,matrix, x);
                    if (sign == false) {
                        return false;
                    }
                }
                matrix[num] = false;
            }
        }
        return true;
    }
}
