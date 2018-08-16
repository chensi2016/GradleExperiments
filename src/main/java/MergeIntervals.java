import java.util.Comparator;
import java.util.List;
class Interval {
      int start;
      int end;
      Interval() {
          start = 0;
          end = 0;
      }
      int getStart(){
          return start;
      }
      int getEnd(){
          return end;
      }
      Interval(int s, int e) {
          start = s; end = e;
      }
  }
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if ( intervals.size() <= 1 ) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(Interval::getStart).thenComparing(Interval::getEnd));
        Interval currentInterval;
        Interval nextInterval;
        int firstPointer = 0;
        int secondPointer = 1;
        while ( secondPointer <=  intervals.size()-1 ) {
            currentInterval = intervals.get(firstPointer);
            nextInterval = intervals.get(secondPointer);

            if ( !(nextInterval.end < currentInterval.start || currentInterval.end < nextInterval.start) ) {
                currentInterval.start = currentInterval.start < nextInterval.start ? currentInterval.start : nextInterval.start;
                currentInterval.end = currentInterval.end > nextInterval.end ? currentInterval.end : nextInterval.end;
                intervals.remove(nextInterval);
            } else {
                firstPointer++;
                secondPointer++;
            }
        }
        return intervals;
    }
}
