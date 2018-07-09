import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressMatchingTest {
    RegularExpressMatchingDPSample regularExpressMatching = new RegularExpressMatchingDPSample();
    String s = "aa";
    String p = "a*";

    @Test
    public void isMatch() {
        assertTrue(regularExpressMatching.isMatch(s, p));
        return;
    }
}