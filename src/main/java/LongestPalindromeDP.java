public class LongestPalindromeDP {
    int stringLength = 1000;
    int[][] palindrome = new int[stringLength][stringLength]; //An array to record whether each substring is palindrome
    String result = "";
    int size; //the current substring's size
    char[] charArray;
    public String longestPalindrome(String s) {
        charArray = s.toCharArray();

        //find the palindrome
        int leftPointer;
        int rightPointer;
        size = 1;
        while ( size <= s.length()) {
            //for each size, the search is from the left, first find the rightPointer which is 'size-1' far from the leftPointer
            leftPointer = 0;
            rightPointer = leftPointer + size -1;
            while (rightPointer < s.length() ){
                if (palindrome(leftPointer, rightPointer)){
                    if(result.length()<size)
                    result = s.substring(leftPointer, rightPointer+1);
                }
                leftPointer++;
                rightPointer++;
            }
            size++;
        }
        return result;


    }

    boolean palindrome(int left, int right){
        if(palindrome[left][right] == 1) {
            return true;
        }
        if(palindrome[left][right] == -1){
            return false;
        }
        if(left==right | (left+1 ) == (right-1) | (left+1) == right ){
            if( charArray[left] == charArray[right]) {
                palindrome[left][right] = 1;
                return true;
            }
            else {
                palindrome[left][right] = -1;
                return false;
            }

        }
        boolean equal = charArray[left] == charArray[right];
        left++;
        right--;

        if ( palindrome(left, right)  && equal){
            palindrome[left][right] = 1;
            return true;
        }
        else {
            palindrome[left][right] = -1;
            return false;
        }
    }
}
