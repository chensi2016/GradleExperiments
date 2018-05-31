import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String s = "babad";

    @Test
    public void longestPalindrome() {
        assertEquals("aba", longestPalindrome.longestPalindrome(s));
        return;

    }
}