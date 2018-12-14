import java.util.ArrayList;
import java.util.List;

public class ZigZagRewrite {
    public String convert(String s, int numRows) {
        if ( numRows >= s.length() || numRows == 1 ) {
            return s;
        }
        List<StringBuilder> work = new ArrayList<>();
        for ( int i = 0; i < numRows; i++) {
            work.add(new StringBuilder());
        }
        int rowNum = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            if ( rowNum == 0 || rowNum == numRows - 1 ) {
                goingDown = !goingDown;
            }
            work.get(rowNum).append(c);
            rowNum += goingDown? 1 : -1;

        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : work ) {
            result = result.append(sb);
        }
        return result.toString();
    }

}
