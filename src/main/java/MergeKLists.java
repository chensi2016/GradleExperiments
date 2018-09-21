class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(){

    }
 }

public  class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int listsLength = lists.length;
        ListNode mergedList = new ListNode();
        int count = 0;
        int currentSmallest;
        int lineNumberofCurrentSmallest;
        do {
            for (int i = 0; i < listsLength; i++) {
                if( lists[i] == null ) {
                    continue;
                }
                count++;
                if ( count == 1 ) {
                    currentSmallest = lists[i].val;
                    lineNumberofCurrentSmallest = i;
                    continue;
                } else {
                    if (lists[i].val < currentSmallest) {
                        currentSmallest = lists[i].val;
                        lineNumberofCurrentSmallest = i;
                    }
                }
            }
            mergedList.next = new ListNode(currentSmallest);
            lists[lineNumberofCurrentSmallest] = lists[lineNumberofCurrentSmallest].next;
        } while ( count!=0 );


    }

}