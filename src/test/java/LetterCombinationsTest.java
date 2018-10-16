import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LetterCombinationsTest {
    LetterCombinations letterCombinations = new LetterCombinations();
    String digits = "23";
    List<String> expected =Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    @Test
    public void letterCombinations() {
        assertThat(letterCombinations.letterCombinations(digits), is(expected));
        return;

    }
}