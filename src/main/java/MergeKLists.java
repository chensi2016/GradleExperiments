class ListNodeForMergeKLists {
    int val;
    ListNodeForMergeKLists next;
    ListNodeForMergeKLists(int x) {
        val = x;
    }
    ListNodeForMergeKLists(){

    }
 }

public  class MergeKLists {
    public ListNodeForMergeKLists mergeKLists(ListNodeForMergeKLists[] lists) {
        int listsLength = lists.length;
        ListNodeForMergeKLists mergedList = new ListNodeForMergeKLists();
        ListNodeForMergeKLists index = mergedList;
        int count = 0;
        int currentSmallest = 0;
        int lineNumberofCurrentSmallest = 0;
        do {
            count = 0;
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
            if ( count == 0 ) {
                break;
            }
            index.next = new ListNodeForMergeKLists(currentSmallest);
            lists[lineNumberofCurrentSmallest] = lists[lineNumberofCurrentSmallest].next;
            index = index.next;
        } while ( count!=0 );

     return mergedList.next;
    }

}