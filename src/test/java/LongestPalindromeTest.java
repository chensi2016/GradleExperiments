import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    LongestPalindromeFast longestPalindrome = new LongestPalindromeFast();
    String s = "abcda";

    @Test
    public void longestPalindrome() {
        assertEquals("a", longestPalindrome.longestPalindrome(s));
        return;

    }
}