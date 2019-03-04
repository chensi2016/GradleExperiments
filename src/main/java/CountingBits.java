public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for ( int i = 0; i <= num; i++ ) {
            int decimal = i;
            String binary = Integer.toString(decimal, 2);
            int count = 0;
            for ( char x: binary.toCharArray() ) {
                if ( x == '1' ) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
