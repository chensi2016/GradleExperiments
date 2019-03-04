public class RotateImage {
    public void rotate(int[][] matrix) {
        int leftUpX = 0;
        int leftUpY = 0;
        int rightDownX = matrix[0].length -1;
        int rightDownY = matrix.length -1;
        int length = matrix[leftUpX].length - 1;
        int[] buffer = new int[4];
        while( length > 0 ) {
            System.out.println(leftUpX + " "+ leftUpY);
            System.out.println(rightDownX + " "+ rightDownY);
            for (int i = 0; i < length; i++) {
                int firstX = leftUpX;
                int firstY = leftUpY + i;
                int secondX = leftUpY + i;
                int secondY = rightDownY;
                int thirdX = rightDownX;
                int thirdY = rightDownY - i;
                int forthX = rightDownX - i;
                int forthY = leftUpY;
                System.out.println(firstX + " "+ firstY);
                System.out.println(secondX + " "+ secondY);
                System.out.println(thirdX + " "+ thirdY);
                System.out.println(forthX + " "+ forthY);
                System.out.println(" ");
                buffer[0] = matrix[firstX][firstY];
                buffer[1] = matrix[secondX][secondY];
                buffer[2] = matrix[thirdX][thirdY];
                buffer[3] = matrix[forthX][forthY];
                matrix[secondX][secondY] = buffer[0];
                matrix[thirdX][thirdY] = buffer[1];
                matrix[forthX][forthY] = buffer[2];
                matrix[firstX][firstY] = buffer[3];
            }
            leftUpX++;
            leftUpY++;
            rightDownX--;
            rightDownX--;
            length = length - 2;
        }

    }
}
