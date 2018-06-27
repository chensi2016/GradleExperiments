import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressMatchingTest {
    RegularExpressMatchingDPRewrite regularExpressMatching = new RegularExpressMatchingDPRewrite();
    String s = "aaa";
    String p = "aaaa";

    @Test
    public void isMatch() {
        assertTrue(regularExpressMatching.isMatch(s, p));
        return;
    }
}