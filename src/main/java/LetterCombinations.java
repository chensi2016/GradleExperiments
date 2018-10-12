import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> letterMap =Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        int number = 0;

        Graph graph = new Graph(26);
        for ( int i = 0; i < digits.length()-1; i++) {
          while(letterMap.get(digits.charAt(i)-'2') ){

          }
            if ( digits.charAt(i) == '7' || digits.charAt(i) == '8') {
                graph.addEdge(digits.charAt(i)-'2',digits.charAt(i+1)-'2');
            } else
            {
                number = number + 4;
            }

        }



    }
}
