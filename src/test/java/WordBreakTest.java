import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class WordBreakTest {


    WordBreak wordbreak = new WordBreak();
    String s = "pineapplepenapple";
    List<String> dict = Arrays.asList("apple","pen","applepen","pine","pineapple");
    List<String> expected = Arrays.asList("pine apple pen apple","pine applepen apple", "pineapple pen apple");

    @Test
    public void wordBreak() {
        assertThat(wordbreak.wordBreak(s,dict), is(expected));
        return;
    }
}



