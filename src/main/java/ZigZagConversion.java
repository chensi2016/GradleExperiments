public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if ( numRows >= s.length() || numRows== 1 ) {
            return s;
        }
        int column = ((s.length()/( numRows - 2 + 1)) + 1)*( numRows - 2 + 1);
        char[][] work = new char[numRows][column];
        int index = 0;
        for (int j = 0; j < column; j++) {
            for ( int i = 0; i < numRows; i ++) {

                if (index < s.length()){
                    if (j % (numRows - 2 + 1) == 0) {
                        work[i][j] = s.charAt(index);
                        index++;
                    } else {
                        if ((numRows - 1 - i) == j % (numRows - 2 + 1)) {
                            work[i][j] = s.charAt(index);
                            index++;
                        }
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < numRows; i++ ) {
            for ( int j= 0; j < column; j++ ) {
                if( work[i][j] != '\u0000') {
                    result.append(work[i][j]);
                }
            }
        }
        return result.toString();
    }
}