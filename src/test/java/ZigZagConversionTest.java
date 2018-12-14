import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagConversionTest {
    ZigZagConversion zigZagConversion = new ZigZagConversion();

    @Test
    public void convert() {
        String s = "AB";
        assertEquals("AB", zigZagConversion.convert(s,1));
    }
}