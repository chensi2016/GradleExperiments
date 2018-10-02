package mergeKListsPackage;

import java.util.ArrayList;
import java.util.List;

public  class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> outsideList = new ArrayList<>();
        for (ListNode node: lists ) {
            if ( node != null) {
                outsideList.add(node);
            }
        }
        if (outsideList.isEmpty()) {
            return null;
        }
        ListNode mergedList = new ListNode();
        ListNode index = mergedList;
        while ( !outsideList.isEmpty() ) {
            ListNode currentSmallestNode = outsideList.get(0);
            for (ListNode node : outsideList) {
                if( node.val < currentSmallestNode.val) {
                    currentSmallestNode = node;
                }
            }
            index.next = new ListNode(currentSmallestNode.val);
            index = index.next;
            if ( currentSmallestNode.next != null ) {
                ListNode nextNode = currentSmallestNode.next;
                currentSmallestNode.val = nextNode.val;
                currentSmallestNode.next = nextNode.next;
            } else {
                outsideList.remove(currentSmallestNode);
            }
        }
     return mergedList.next;
    }

}