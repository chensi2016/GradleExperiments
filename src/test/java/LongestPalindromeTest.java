import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    LongestPalindromeDP longestPalindrome = new LongestPalindromeDP();
    String s = "abb";

    @Test
    public void longestPalindrome() {
        assertEquals("bb", longestPalindrome.longestPalindrome(s));
        return;

    }
}