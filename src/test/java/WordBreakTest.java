import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class WordBreakTest {


    WordBreak wordbreak = new WordBreak();
    //String s = "catsanddog";
   // List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
   // List<String> expected = Arrays.asList("cats and dog","cat sand dog");

    String s = "aanddog";
    List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
    List<String> expected = Arrays.asList();

    @Test
    public void wordBreak() {
        assertThat(wordbreak.wordBreak(s,dict), is(expected));
        return;
    }
}




