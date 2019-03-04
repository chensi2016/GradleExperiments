public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n -1;
        if ( start != end ) {
            mergeSort(nums, start, end);
        }

    }
    void mergeSort(int[] nums, int start, int end) {
        int mid = (start + end)/2;
        if( start != end ) {
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums,start,mid,end);
        }

    }
    void merge(int[] nums, int start, int mid, int end){

        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];
        int k = 0;
        for( int i = start; i <= mid; i++ ) {
            leftArray[k] = nums[i];
            k++;
        }
        leftArray[n1] = Integer.MAX_VALUE;
        k = 0;
        for( int i = mid + 1; i <= end; i++ ) {
            rightArray[k] = nums[i];
            k++;
        }
        rightArray[n2] = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        for (int i = start; i <= end; i++) {
            if( leftArray[index1] <= rightArray[index2] ) {
                nums[i] = leftArray[index1];
                index1++;
            }else{
                nums[i] = rightArray[index2];
                index2++;
            }

        }
    }

}
