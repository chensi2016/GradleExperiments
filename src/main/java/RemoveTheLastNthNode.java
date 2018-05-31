class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


public class RemoveTheLastNthNode {
    ListNode head = new ListNode(0);

    public ListNode removeNthFromEnd(ListNode givenList, int n){
        ListNode firstPointer;
        ListNode secondPointer;
        head.next = givenList;
        firstPointer = head;
        secondPointer = head;
        for (int i=0;i<n;i++ ){
            firstPointer = firstPointer.next;
        }
        while( firstPointer.next != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        ListNode toDeleteNode = secondPointer.next;
        ListNode toDeleteNodeNext = toDeleteNode.next;
        secondPointer.next = toDeleteNodeNext;
        return head.next;
    }
}
