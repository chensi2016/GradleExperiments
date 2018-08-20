public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if( nums.length == 0 ) {
            return -1;

        }
        int pointer = 0;
        int nextPointer = nums.length/2;
        int temp;
        do{
            if (pointer > nums.length -1 || nextPointer > nums.length -1 || nextPointer < 0) {
                return -1;
            }
            if ( nums[pointer] == target || nums[nextPointer] == target) {
                if (nums[pointer] == target) {
                    return pointer;
                } else {
                    return nextPointer;
                }
            } else {
                temp = pointer;
                int step;
                if ( nextPointer - temp > 1 ){
                    step = ( nextPointer - temp )/2;
                } else {
                    step = 1;
                }
                if ( nums[pointer] < nums[nextPointer] ) {
                    if ( target < nums[pointer] || target > nums[nextPointer]) {
                        pointer = nextPointer;
                        nextPointer = nextPointer + step;
                    } else {
                        pointer = nextPointer;
                        nextPointer = nextPointer - step;
                    }

                }  else {
                    if ((target < nums[pointer] && target < nums[nextPointer] ) || target > nums[pointer] ) {
                        pointer = nextPointer;
                        nextPointer = nextPointer - step;
                    } else {
                        pointer = nextPointer;
                        nextPointer = nextPointer + step;

                    }
                }
            }
        } while (pointer != nextPointer && nextPointer != temp);
        return -1;
    }
}
