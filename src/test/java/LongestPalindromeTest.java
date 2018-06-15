import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    LongestPalindromeDP longestPalindrome = new LongestPalindromeDP();
    String s = "ccc";

    @Test
    public void longestPalindrome() {
        assertEquals("ccc", longestPalindrome.longestPalindrome(s));
        return;

    }
}