import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressMatchingTest {
    RegularExpressMatchingDP regularExpressMatching = new RegularExpressMatchingDP();
    String s = "aa";
    String p = "a";

    @Test
    public void isMatch() {
        assertFalse(regularExpressMatching.isMatch(s, p));
        return;
    }
}