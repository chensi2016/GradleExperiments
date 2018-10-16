import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    List<String> letterMap =Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
    List<String> result = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if ( digits==null ) {
            return null;
        }
        if ( digits.length() == 0 ) {

            return result;
        }
        DFS(digits, -1, "");
        return result;
    }
    void DFS(String digits, int index, String previous) {
        String newPrevious = new String(previous);
        if( index == digits.length() -1 ) {
            result.add(newPrevious);
            return;
        }
        int nextNumber = digits.charAt(index + 1) - '2';
        for ( int i = 0; i < letterMap.get(nextNumber).length(); i++ ) {
            newPrevious += letterMap.get(nextNumber).charAt(i);
            DFS(digits, index + 1, newPrevious);
            newPrevious = newPrevious.substring(0, newPrevious.length()-1);

        }
    }

}
