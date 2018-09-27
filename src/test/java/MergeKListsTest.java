import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKListsTest {
    MergeKListsByHeap mergeKLists = new MergeKListsByHeap();

    @Test
    public void mergeKLists() {
        ListNodeForMergeKLists first1 = new ListNodeForMergeKLists(1);
        ListNodeForMergeKLists first2 = new ListNodeForMergeKLists(4);
        ListNodeForMergeKLists first3 = new ListNodeForMergeKLists(5);
        ListNodeForMergeKLists second1 = new ListNodeForMergeKLists(1);
        ListNodeForMergeKLists second2 = new ListNodeForMergeKLists(3);
        ListNodeForMergeKLists second3 = new ListNodeForMergeKLists(4);
        ListNodeForMergeKLists third1 = new ListNodeForMergeKLists(2);
        ListNodeForMergeKLists third2 = new ListNodeForMergeKLists(6);
        first1.next = first2;
        first2.next = first3;
        second1.next = second2;
        second2.next = second3;
        third1.next = third2;
        ListNodeForMergeKLists[] lists = {first1,second1,third1};
        ListNodeForMergeKLists ExpectedList = new ListNodeForMergeKLists(2);
        assertEquals(mergeKLists.mergeKLists(lists).next.next.val, ExpectedList.val);
        return;

    }
}