import java.util.ArrayList;
//import java.util.Comparator;
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
        mergesort(intervals);
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
    List<Interval> mergesort(List<Interval> intervals) {
        int length = intervals.size();
        if ( length >= 2 ) {
            List<Interval> left = new ArrayList<>(length/2);
            List<Interval> right = new ArrayList<>(length - length/2);
            for (int i = 0; i < length/2; i++) {
                left.add(intervals.get(i));
            }
            for (int i = length/2; i < length; i++) {
                right.add(intervals.get(i));
            }
            List<Interval> sortedLeft = mergesort(left);
            List<Interval> sortedRight = mergesort(right);
            int searchFrom = 0;
            for ( int i = 0; i < sortedRight.size(); i++) {
                if ( sortedRight.get(i).start >= sortedLeft.get(sortedLeft.size()-1).start) {
                    for (int p = i; p < sortedRight.size(); p++) {
                        sortedLeft.add(sortedRight.get(p));
                    }

                        return sortedLeft;
                } else{
                    for ( int j = searchFrom; j < sortedLeft.size(); j++ ){
                        if (sortedRight.get(i).start < sortedLeft.get(j).start ) {
                            sortedLeft.add(j, sortedRight.get(i));
                            searchFrom = j;
                            break;
                        }
                    }

                }
            }
            return sortedLeft;
        } else {
            return intervals;
        }

    }
}
