import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeIntervalsTest {
    MergeIntervals mergeIntervals = new MergeIntervals();



    @Test
    public void mergesort() {
        List<Interval> inputList = new ArrayList<Interval>(5);
        inputList.add(new Interval(2,3));
        inputList.add(new Interval(4,5));
        inputList.add(new Interval(6,7));
        inputList.add(new Interval(8,9));
        inputList.add(new Interval(1,10));

        List<Interval> ExpectedList = new ArrayList<Interval>(1);
        List<Interval> OutputList = mergeIntervals.merge(mergeIntervals.mergesort(inputList));
        ExpectedList.add(new Interval(1,10));
        assertEquals(OutputList.size(), ExpectedList.size());
        return;

    }
}