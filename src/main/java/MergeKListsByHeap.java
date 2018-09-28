public class MergeKListsByHeap {
    int arrayLength = 0;
    public ListNodeForMergeKLists mergeKLists(ListNodeForMergeKLists[] lists) {
        for ( int i = 0; i < lists.length; i++ ) {
            ListNodeForMergeKLists pointer = lists[i];
            while( pointer != null ) {
                arrayLength++;
                pointer = pointer.next;
            }
        }

        int[] array = new int[arrayLength];
        int index = 0;
        for ( int i = 0; i < lists.length; i++ ) {
            ListNodeForMergeKLists pointer = lists[i];
            while( pointer != null ) {
                array[index] = pointer.val;
                 pointer = pointer.next;
                 index++;
            }
        }
        buildMinHeap(array, arrayLength);

        ListNodeForMergeKLists mergedList = new ListNodeForMergeKLists();
        ListNodeForMergeKLists previous = mergedList;
        while( arrayLength != 0 ) {
            ListNodeForMergeKLists node = new ListNodeForMergeKLists(extractMin(array));
            previous.next = node;
            previous = node;
        }
        return mergedList.next;

        }

    void minHeapify ( int[] array, int index, int number) {
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
    void buildMinHeap ( int[] array, int number) {
        for (int i = number / 2 - 1; i>=0; i--) {
            minHeapify(array, i, number);
        }
    }
    int extractMin( int[] array){
        int min = array[0];
        array[0] = array[arrayLength - 1];
        arrayLength = arrayLength - 1;
        minHeapify(array,0,arrayLength);
        return min;
    }

}


