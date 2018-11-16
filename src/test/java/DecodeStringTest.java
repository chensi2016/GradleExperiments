import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {
    DecodeStringRewrite decodeString = new DecodeStringRewrite();
    String s = "3[a2[c]]";
    String expected = "accaccacc";

    @Test
    public void decodeString() {
        assertEquals(expected, decodeString.decodeString(s));
    }
}