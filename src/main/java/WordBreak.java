
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    List<String> dict;
    List<Integer> wordBorder;
    public List<String> wordBreak(String s, List<String> wordDict) {

        this.dict = wordDict;
        this.wordBorder = new ArrayList<>();
        List<String> result = new ArrayList<>();
        check(s, s.length());
        int borderNumber = wordBorder.size();
        String word = "";
        int prev;
        int findTail;
        for ( int i = 0; i < borderNumber-1; i++ ) {
            if ( wordBorder.get( i + 1 ) == 0) {
                prev = i;
                findTail = i;
                findTail ++ ;
                while ( wordBorder.get( findTail) != wordBorder.get( prev )){
                    findTail++;
                }
                while (wordBorder.get( findTail+1) != s.length()){
                    word = word + s.substring(wordBorder.get(findTail), wordBorder.get(findTail+1)) + " ";
                    findTail++;
                }
                word = word + s.substring( wordBorder.get( findTail ), wordBorder.get( findTail + 1 ) );
                result.add(word);
                word = "";
                continue;
            }
            if ( wordBorder.get( i + 1 ) == s.length() ){
                word = word + s.substring( wordBorder.get( i ), wordBorder.get( i + 1 ) );
                result.add(word);
                word = "";
            }else {
                if( wordBorder.get( i ) == s.length() ){
                    continue;
                }
                word = word + s.substring(wordBorder.get(i), wordBorder.get(i+1)) + " ";
            }
        }
        return result;


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
                if ( s.charAt(tempNthCharOfS -1) == dict.get(i).charAt(j) ) {
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