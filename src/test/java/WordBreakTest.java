import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class WordBreakTest {


    WordBreak wordbreak = new WordBreak();
    String s = "catsanddog";
    List<String> dict = Arrays.asList("cat","cats","and","sand","dog");
    List<String> expected = Arrays.asList("cat sand dog", "cats and dog");

    @Test
    public void wordBreak() {
        assertThat(wordbreak.wordBreak(s,dict), is(expected));
        return;
    }
}