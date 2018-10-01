import mergeKListsPackage.MergeKLists;
import mergeKListsPackage.MergeKListsByHeap;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MergeKListsTest {
    MergeKListsByHeap mergeKLists = new MergeKListsByHeap();

    @Test
    public void mergeKLists() {
        mergeKListsPackage.ListNode first1 = new mergeKListsPackage.ListNode(1);
        mergeKListsPackage.ListNode first2 = new mergeKListsPackage.ListNode(4);
        mergeKListsPackage.ListNode first3 = new mergeKListsPackage.ListNode(5);
        mergeKListsPackage.ListNode second1 = new mergeKListsPackage.ListNode(1);
        mergeKListsPackage.ListNode second2 = new mergeKListsPackage.ListNode(3);
        mergeKListsPackage.ListNode second3 = new mergeKListsPackage.ListNode(4);
        mergeKListsPackage.ListNode third1 = new mergeKListsPackage.ListNode(2);
        mergeKListsPackage.ListNode third2 = new mergeKListsPackage.ListNode(6);
        first1.next = first2;
        first2.next = first3;
        second1.next = second2;
        second2.next = second3;
        third1.next = third2;
        mergeKListsPackage.ListNode[] lists = {first1,second1,third1};
        mergeKListsPackage.ListNode ExpectedList = new mergeKListsPackage.ListNode(2);
        assertEquals(mergeKLists.mergeKLists(lists).next.next.val, ExpectedList.val);
        return;

    }
}