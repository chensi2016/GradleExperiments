public class SortColorsOnePass {
    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length - 1;
        int k = 0;
        while( k <= j ) {
            if( nums[k] < 1 ){
                i++;
                swap(nums,k,i);
                k++;
            }else if( nums[k] > 1) {
                swap(nums,k,j);
                k++;
                j--;
            } else{
                k++;
            }

        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
