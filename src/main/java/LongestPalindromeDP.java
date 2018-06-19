public class LongestPalindromeDP {
    int stringLength = 1000;
    boolean[][] palindrome = new boolean[stringLength][stringLength]; //An array to record whether each substring is palindrome
    String result = "";
    int size; //the current longest palindrome's size
    char[] charArray;
    public String longestPalindrome(String s) {
        charArray = s.toCharArray();

        //find the palindrome
        int leftpointer;
        int rightpointer;
        size = 1;
        while ( size <= s.length()) {
            //for each size, the search is from the left, first find the rightpointer which is 'size' far from the leftpointer
            leftpointer = 0;
            rightpointer = leftpointer + size -1;
            while (rightpointer < s.length() ){
                if (palindrome(leftpointer, rightpointer)){
                    if(result.length()<size)
                    result = s.substring(leftpointer, rightpointer+1);
                }
                leftpointer++;
                rightpointer++;
            }
            size++;
        }
        return result;

    }

    boolean palindrome(int left, int right){
        if(palindrome[left][right] == true) {
            return true;
        }
        if(left==right | (left+1 ) == (right-1) | (left+1) == right ){
            if( charArray[left] == charArray[right]) {
                palindrome[left][right] = true;
                return true;
            }
            else
                return false;

        }
        boolean equql = charArray[left] == charArray[right];
        left++;
        right--;

        if ( palindrome(left, right)  && equql){
            palindrome[left][right] = true;
            return true;
        }
        else
            return false;
    }
}
