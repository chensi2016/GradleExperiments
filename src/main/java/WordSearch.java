public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rowNumber = board.length;
        int columnNumber = board[0].length;
        for ( int i = 0; i < rowNumber; i++ ) {
            for ( int j = 0; j < columnNumber; j++ ) {
                    boolean[][] checked = new boolean[rowNumber][columnNumber];
                    if (DFS(board, checked, i, j, word,0)) {
                        return true;
                    }
            }

        }
        return false;
    }
    boolean DFS(char[][] board, boolean[][] checked,int rowIndex, int columnIndex, String word, int wordIndex){
        if ( wordIndex == word.length() -1 && board[rowIndex][columnIndex] == word.charAt(wordIndex)) {
            return true;
        }
        int[][] location = {{-1,0},{1,0},{0,-1},{0,1}};
        if (board[rowIndex][columnIndex] == word.charAt(wordIndex)) {
            checked[rowIndex][columnIndex] = true;
            for (int i = 0; i < location.length; i++) {
                int newRowIndex = rowIndex + location[i][0];
                int newColumnIndex = columnIndex + location[i][1];
                if (newRowIndex > board.length-1 || newRowIndex < 0 || newColumnIndex > board[0].length-1 || newColumnIndex < 0) {
                    continue;
                } else {
                    if (checked[newRowIndex][newColumnIndex] == false ) {
                        if (DFS(board, checked, newRowIndex, newColumnIndex, word, wordIndex + 1) == true) {
                            return true;
                        }
                    }
                }
            }
            checked[rowIndex][columnIndex] = false;
        }
        return false;
    }
}
