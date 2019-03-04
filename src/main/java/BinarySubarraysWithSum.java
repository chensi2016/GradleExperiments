public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] G = new int[A.length];
        for( int i = 0; i < A.length; i++ ) {
            int sum = 0;
            for ( int j = 0; j < A.length; j++) {
                G[sum]++;
            }
        }
        return G[S];

    }
}
