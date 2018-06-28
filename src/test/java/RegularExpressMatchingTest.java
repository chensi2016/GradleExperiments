import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressMatchingTest {
    RegularExpressMatchingDPRewrite regularExpressMatching = new RegularExpressMatchingDPRewrite();
    String s = "ab";
    String p = ".*..";

    @Test
    public void isMatch() {
        assertTrue(regularExpressMatching.isMatch(s, p));
        return;
    }
}