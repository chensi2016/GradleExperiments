import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {

                if ( a[1] == b[1] ) {
                    return a[0] - b[0];

                }
                return a[1] - b[1];
            }
        });
        for ( int i = 0; i < people.length; i++ ) {
            int count = 0;
            int numGreaterorEqual = 0;
            int flag = 0;
            while(count < i) {
                if ( people[count][0] >= people[i][0] ){
                    numGreaterorEqual++;
                }
                count++;
                if( numGreaterorEqual == people[i][1] ) {
                    flag = count;
                }
            }
            if ( numGreaterorEqual == people[i][1] ) {
                continue;
            }
            int[][] temp = new int[1][2];
            temp[0][0] = people[i][0];
            temp[0][1] = people[i][1];
            for ( int j = i - 1; j >= flag; j-- ) {
                people[j + 1][0] = people[j][0];
                people[j + 1][1] = people[j][1];
            }
            people[flag][0] = temp[0][0];
            people[flag][1] = temp[0][1] ;
        }
        return people;
    }

}
