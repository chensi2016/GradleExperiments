import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {
    TriangleRewrite triangle = new TriangleRewrite();
    @Test
    public void minimumTotal() {

        List<Integer> numberList1 = Arrays.asList(2);
        List<Integer> numberList2 = Arrays.asList(3,4);
        List<Integer> numberList3 = Arrays.asList(6,5,7);
        List<Integer> numberList4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> list  = new ArrayList<>();
        list.add(numberList1);
        list.add(numberList2);
        list.add(numberList3);
        list.add(numberList4);
        assertEquals(11, triangle.minimumTotal(list));
    }
}