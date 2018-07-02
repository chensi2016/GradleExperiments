import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressMatchingTest {
    RegularExpressMatchingRealDP regularExpressMatching = new RegularExpressMatchingRealDP();
    String s = "asdfasdfas";
    String p = "asdf.*asdf.*s";

    @Test
    public void isMatch() {
        assertTrue(regularExpressMatching.isMatch(s, p));
        return;
    }
}