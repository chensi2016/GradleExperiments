import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    LongestPalindromeRewrite longestPalindrome = new LongestPalindromeRewrite();
    String s = "abb";

    @Test
    public void longestPalindrome() {
        assertEquals("bb", longestPalindrome.longestPalindrome(s));
        return;

    }
}