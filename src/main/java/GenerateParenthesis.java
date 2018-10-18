import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if ( n == 0 ) {
            return result;
        }
        DFS(0, 0, n, "");
        return result;
        }
    void DFS(int left, int right, int n, String pre) {
        if(left == n && right == n)
        {
            result.add(pre);
            return;
        }
        if ( left == n && right <= n-1 ) {
            String newPre = pre +')';
            DFS(left, right + 1, n, newPre);
        }
        if( left >right && left <= n - 1 && right <= n - 1) {
            String newPre = pre + '(';
            DFS(left + 1, right, n, newPre);
            newPre = pre +')';
            DFS(left, right + 1, n, newPre);

        } else {
            if (left == right && left <= n - 1) {
                String newPre = pre + '(';
                DFS(left + 1, right, n, newPre);
            }
        }
    }
}
