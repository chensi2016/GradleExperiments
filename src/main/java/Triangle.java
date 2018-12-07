import java.util.List;

public class Triangle {
    int[][] record;
    public int minimumTotal(List<List<Integer>> triangle) {
        record = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for ( int i = 0; i < triangle.size(); i++) {
            for ( int j = 0; j <triangle.get(triangle.size()-1).size(); j++  ) {
                record[i][j] = Integer.MAX_VALUE;
            }
        }
        if (triangle.size() == 0) {
            return 0;
        }
        return minimumTotalHelper(triangle, 0 , 0);

    }
    private int minimumTotalHelper( List<List<Integer>> triangle, int rowNumber, int dataIndex) {
        if ( record[rowNumber][dataIndex] < Integer.MAX_VALUE) {
            return record[rowNumber][dataIndex];
        }
        int sum = 0;
        if ( rowNumber == triangle.size() -1 ) {
            sum = triangle.get(rowNumber).get(dataIndex);
            //System.out.println("rowNumber is "+ rowNumber + " dataIndex is " + dataIndex + " sum is " + sum);
            record[rowNumber][dataIndex] = sum;
            return sum;
        } else {
            sum = triangle.get(rowNumber).get(dataIndex)  +  Math.min( minimumTotalHelper(triangle, rowNumber + 1, dataIndex), minimumTotalHelper(triangle, rowNumber + 1 , dataIndex +1) );
        }
       // System.out.println("rowNumber is "+ rowNumber + " dataIndex is " + dataIndex + " sum is " + sum);
        record[rowNumber][dataIndex] = sum;
        return sum;
    }
}
