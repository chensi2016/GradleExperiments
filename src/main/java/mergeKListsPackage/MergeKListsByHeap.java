package mergeKListsPackage;

import java.util.ArrayList;
import java.util.List;

public class MergeKListsByHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> outsideList = new ArrayList<>();
        for ( ListNode node: lists ) {
            while ( node != null ) {
                ListNode nextPointer = node.next;
                outsideList.add(node.val);
                node = nextPointer;
            }
        }
        Integer[] array = new Integer[outsideList.size()];
        array = outsideList.toArray(array);

        buildMinHeap(array, array.length);

        ListNode mergedList = new ListNode(0);
        ListNode index = mergedList;
        int numberOfInteger = array.length;
        while( numberOfInteger != 0 ) {
            index.next = new ListNode(extractMin(array, numberOfInteger));
            index = index.next;
            numberOfInteger--;
        }
        return mergedList.next;
        }

    void minHeapify ( Integer[] array, int index, int number) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest;
        if ( left < number && array[left] <= array[index] ) {
            smallest = left;
        } else {
            smallest = index;

        }
        if ( right < number && array[right] <= array[smallest] ) {
            smallest = right;
        }
        if ( smallest != index) {
            int temp = array[smallest];
            array[smallest] = array[index];
            array[index] = temp;
            minHeapify( array, smallest, number);
        }
    }
    void buildMinHeap (Integer[] array, int number) {
        for (int i = number / 2 - 1; i>=0; i--) {
            minHeapify(array, i, number);
        }
    }
    int extractMin(Integer[] array, int number){
        int min = array[0];
        array[0] = array[number - 1];
        minHeapify(array,0,number -1 );
        return min;
    }

}


