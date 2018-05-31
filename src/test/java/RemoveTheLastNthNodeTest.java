import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveTheLastNthNodeTest {
    ListNode listNode1;
    ListNode listNode2;
    ListNode listNode3;
    ListNode listNode4;
    ListNode listNode5;

    @Before
    public void setUp() throws Exception {
        listNode1 = new ListNode(1);
        listNode2 = new ListNode(2);
        listNode3 = new ListNode(3);
        listNode4 = new ListNode(4);
        listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
    }

    @Test
    public void removeNthFromEnd() {
        RemoveTheLastNthNode removeTheLastNthNode = new RemoveTheLastNthNode();
        ListNode result = removeTheLastNthNode.removeNthFromEnd(listNode1, 2);
        assertEquals(listNode1, result);
    }
}