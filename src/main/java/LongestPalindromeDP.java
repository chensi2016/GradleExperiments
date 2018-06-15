public class LongestPalindromeDP {
    StringNode head = new StringNode('x');
    int stringNodeLength = 1000;
    StringNode[] string = new StringNode[stringNodeLength];
    boolean[][] palindrome = new boolean[stringNodeLength][stringNodeLength]; //An array to record whether each substring is palindrome
    String result = "";
    int size; //the current longest palindrome's size
    public String longestPalindrome(String s) {
        for (int i = 0; i < stringNodeLength; i++) {
            string[i] = new StringNode();
        }

        for (int i = 0; i < s.length(); i++) {
            string[i].aChar = s.charAt(i);
            if (i == 0) {
                head.next = string[i];
                string[i].previous = head;
            } else {
                string[i - 1].next = string[i];
                string[i].previous = string[i - 1];
            }
            string[i].next = head;
            head.previous = string[i];
        }

        //find the palindrome
        StringNode leftpointer;
        StringNode rightpointer;
        StringNode left; //a small pointer inside leftpointer and rightpointer
        StringNode right; //a small pointer inside leftpointer and rightpointer
        size = s.length();
        while ( size != 0) {
            leftpointer = head.next;
            rightpointer = head.previous;
            //for each size, the search is from the left, first find the rightpointer which is 'size' far from the leftpointer
            int i = s.length();
            while (i > size)
            {
                rightpointer = rightpointer.next;
                i--;
            }
            while (rightpointer != head ){
                result = BuildResultString(leftpointer, rightpointer);
                left = leftpointer;
                right = rightpointer;
                if (palindrome(left, right)){
                    return result;
                }
                leftpointer = leftpointer.next;
                rightpointer = rightpointer.next;
            }
            size--;
        }
        return result;

    }

    private String BuildResultString(StringNode left, StringNode right){
        String result = "";
        StringNode node = left;
        while (node != right.next){
            result += node.aChar;
            node = node.next;
        }
        return result;
    }

    boolean palindrome(StringNode left, StringNode right){
        if(left==right |left.next == right.previous | left.next==right){
            if( left.aChar == right.aChar)
                return true;
            else
                return false;

        }
        if ( palindrome(left.next, right.previous)  && left.aChar == right.aChar){
            return true;
        }
        else
            return false;
    }
}
