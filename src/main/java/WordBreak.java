
import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    List<String> dict;
    List<Integer> wordBorder;
    List<String> result = new ArrayList<>();
    String s;
    Integer[] state;
    Integer[] pointerNext;
    public List<String> wordBreak(String s, List<String> wordDict) {

        this.dict = wordDict;
        this.wordBorder = new ArrayList<>();
        this.s = s;
        check(s, s.length());
        if (wordBorder.size() == 0) {
            return null;
        }
        this.state = new Integer[wordBorder.size()+1];
        this.pointerNext = new Integer[wordBorder.size()+1];

        searchNext(0,s.length(), 0);

        return result;


    }

    Integer searchNext(int pointer, int sLength, int prev) {

        int old = prev;
        Integer next = null;
        String word = "";
        word = word + s.substring(wordBorder.get(pointer), wordBorder.get(pointer+1));
        pointer++;
        while (wordBorder.get(pointer) != null) {
            while (wordBorder.get(pointer) != sLength) {

                if (wordBorder.get(pointer + 1) == 0) {
                    if (state[pointer] != null) {
                        word = word + " " + s.substring(wordBorder.get(pointer), wordBorder.get(pointerNext[pointer]));
                        if (wordBorder.get(pointer) == wordBorder.get(old)) {
                            next = pointerNext[pointer];
                            pointerNext[old] = next;
                        }
                        pointer = pointerNext[pointer];

                        continue;
                    }
                    prev = pointer;
                    pointer++;
                    int prevsnext = searchNext(pointer, sLength, prev);
                    word = word + " " + s.substring(wordBorder.get(prev), wordBorder.get(prevsnext));
                    pointer = prevsnext;
                    continue;

                }
                if (wordBorder.get(pointer) == wordBorder.get(old)) {
                    next = pointer + 1;
                    pointerNext[old] = next;
                }
                word = word + " " + s.substring(wordBorder.get(pointer), wordBorder.get(pointer + 1));
                pointer++;
            }
            result.add(word);
            state[prev] = 1;
            pointer++;
            if( pointer == wordBorder.size()){
                return next;
            }
            else {
                searchNext(pointer, sLength, 0);
            }
        }
        return next;
    }
    private boolean check(String s, int nthCharOfS) {

        int dictLength = dict.size();

        if ( nthCharOfS == 0 ){
            wordBorder.add(nthCharOfS);
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < dictLength; i++) {
            int tempNthCharOfS = nthCharOfS;
            for (int j = dict.get(i).length()-1; j >= 0; j-- ) {
                if ( tempNthCharOfS>=1 && s.charAt(tempNthCharOfS -1) == dict.get(i).charAt(j) ) {
                    tempNthCharOfS--;
                    if( j == 0 ) {
                        if ( check(s, tempNthCharOfS) == true) {
                            wordBorder.add(nthCharOfS);
                            flag = true;
                        }
                    }

                }
                else{
                    break;
                }
            }
        }
    if( flag == true) {
        return true;
    }
    else {
            return false;
    }
    }

}