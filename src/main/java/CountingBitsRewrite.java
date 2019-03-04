public class CountingBitsRewrite {
    public int[] countBits(int num) {
        int[] result = new int[num+ 1];
        int[] work = new int[num + 1];
        int index = 1;
        int numOfOne = 0;
        result[0] = numOfOne;
        while ( index <= num ) {
            int bitIndex = 0;
            while( work[bitIndex] != 0) {
                work[bitIndex] = 0;
                numOfOne--;
                bitIndex++;
            }
            work[bitIndex] = 1;
            numOfOne++;
            result[index] = numOfOne;
         index++;
        }
        return result;
    }
}
