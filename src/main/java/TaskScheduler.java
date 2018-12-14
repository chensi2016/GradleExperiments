import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        List<List<Character>> list = getList(tasks);
        List<Character> result = new ArrayList<>();
        list.sort(new Comparator<List<Character>>() {
            @Override
            public int compare(List<Character> o1, List<Character> o2) {
                return o2.size() - o1.size();
            }
        });
        while( list.get(0).size() > 0 ) {
            int flag = 0;
            while (flag <= n) {
                if ( list.get(0).size() == 0 ) {
                    break;
                }
                int count = 0;
                if ( flag < list.size() && list.get(flag).size() != 0 ) {
                    List<Character> charList = list.get(flag);
                    result.add(charList.get(charList.size() - 1));
                    charList.remove(charList.size() - 1);
                    count++;
                }
                if( count ==0) {
                    result.add(' ');
                }
                flag++;
            }
            list.sort(new Comparator<List<Character>>() {
                @Override
                public int compare(List<Character> o1, List<Character> o2) {
                    return o2.size() - o1.size();
                }
            });
        }
        System.out.println(result.toString());
        return result.size();

    }
    List<List<Character>> getList(char[] tasks) {
        List<List<Character>> list = new ArrayList<>();

        for ( char c : tasks ) {
            boolean exit = false;
            for (List<Character> charList: list) {
                if( charList.get(0) == c ) {
                    charList.add(c);
                    exit = true;
                }
            }
            if (exit == false) {
                List<Character> newCharList = new ArrayList<>();
                newCharList.add(c);
                list.add(newCharList);
            }
        }
        return list;
    }
}
