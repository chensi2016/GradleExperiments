public class Searcha2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) {
            return false;
        }
        int colums = matrix[0].length;
        for(int i = 0; i < Math.min(rows,colums); i++) {
            if(matrix[i][i] == target){
                return true;
            }else if(matrix[i][i] > target){
                for(int j = 0; j < i; j++){
                    if(matrix[i][j] == target || matrix[j][i] == target)
                        return true;
                }

            }
        }
        if(rows < colums){
            for( int i = 0; i < rows; i++ ){
                if(matrix[i][colums-1] == target){
                    return true;
                }else if(matrix[i][colums-1] > target) {
                    for(int j = rows; j < colums; j++) {
                        if (matrix[i][j] == target || matrix[i][j] == target)
                            return true;
                    }
                }
            }
        } else if( rows > colums ){
            for( int j = 0; j < colums; j++ ){
                if(matrix[rows-1][j] == target){
                    return true;
                }else if(matrix[rows-1][j] > target) {
                    for(int i = colums; i < rows; i++) {
                        if (matrix[i][j] == target || matrix[i][j] == target)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
