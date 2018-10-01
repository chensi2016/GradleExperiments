package mergeKListsPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public  class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> outsideList = new ArrayList<>();
        for (ListNode node: lists ) {
            outsideList.add(node);
        }
        if (outsideList.isEmpty()) {
            return new ListNode(0).next;
        }

        ListNode mergedList = new ListNode();
        ListNode index = mergedList;

        ListIterator<ListNode> pointerOfArrayList = outsideList.listIterator();
        int currentSmallest = outsideList.get(0).val;
        ListNode pointer;
        ListNode currentSmallestNode = outsideList.get(0);
        while ( !outsideList.isEmpty() ) {
            pointer = pointerOfArrayList.next();
            if( pointer.val < currentSmallest) {
                currentSmallest = pointer.val;
                currentSmallestNode = pointer;
            }
            if ( !pointerOfArrayList.hasNext() ) {
                index.next = new ListNode(currentSmallest);
                index = index.next;

                if ( currentSmallestNode.next != null ) {
                    outsideList.remove(currentSmallestNode);
                    currentSmallestNode = currentSmallestNode.next;
                    outsideList.add(currentSmallestNode);

                } else {
                    outsideList.remove(currentSmallestNode);
                }
                if ( !outsideList.isEmpty()  ) {
                    currentSmallest = outsideList.get(0).val;
                    currentSmallestNode = outsideList.get(0);
                    pointerOfArrayList = outsideList.listIterator();
                }
            }
        }
     return mergedList.next;
    }

}