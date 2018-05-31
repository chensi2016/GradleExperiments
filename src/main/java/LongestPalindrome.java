
class StringNode {
    char aChar;
    StringNode next;
    StringNode previous;
    StringNode(char aChar){
        this.aChar = aChar;
        this.next = this;
        this.previous = this;
    }


}
public class LongestPalindrome {
    StringNode head = new StringNode('a');
    StringNode string;
    String result;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++){
            string[i].aChar= s.charAt(i);
            if (i == 0){
                head.next = string[i];
                string[i].previous = head;
            }else{
                string[i-1].next = string[i];
                string[i].previous = string[i-1];
            }
            string[i].next = head;
            head.previous = string[i];
        }

        //seek for an odd numbered palindrome
        StringNode pointer = head.next;
        StringNode leftPointer = pointer;
        StringNode rightPointer = pointer;
        while (pointer != head ) {
            result = SeekForPalindrome(leftPointer, rightPointer, 1);
            pointer = pointer.next;
        }

        //seek for an even numbered palindrome
        pointer = head.next;
        while (pointer.next != head ){
            if (pointer.aChar == pointer.next.aChar){
                leftPointer = pointer;
                rightPointer = pointer.next;
                result = SeekForPalindrome(leftPointer, rightPointer, 0);
            }
            pointer = pointer.next;

        }
        return result;
    }
    private String BuildResultString(StringNode left, StringNode right){
        String result = null;
        StringNode node = left;
        while (node != right.next){
            result += node.aChar;
        }
        return result;
    }

    //seek for palindrome
    private String SeekForPalindrome(StringNode leftPointer, StringNode rightPointer, int size){
            while (leftPointer.previous != head && leftPointer.next != head ){
                if (leftPointer.previous.aChar == rightPointer.next.aChar){
                    leftPointer = leftPointer.previous;
                    rightPointer = rightPointer.next;
                    size = size +2;
                    continue;
                } else{
                    if (size > result.length()){
                        result = BuildResultString(leftPointer, rightPointer);
                    }
                    break;
                }

            }
        return result;

    }
    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "babad";
        System.out.println(longestPalindrome.longestPalindrome(s));


    }
}
