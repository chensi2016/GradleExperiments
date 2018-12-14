import org.junit.Test;

import static org.junit.Assert.*;

public class StringtoIntegerTest {
    StringtoInteger stringtoInteger = new StringtoInteger();

    @Test
    public void myAtoi() {
        String str = "-91283472332";
        assertEquals(12345678, stringtoInteger.myAtoi(str));
    }
}