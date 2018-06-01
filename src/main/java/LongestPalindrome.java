
class StringNode {
    char aChar;
    StringNode next;
    StringNode previous;
    StringNode(char aChar){
        this.aChar = aChar;
        this.next = this;
        this.previous = this;
    }
    StringNode(){

    }

}
public class LongestPalindrome {
    StringNode head = new StringNode('x');
    int stringNodeLength = 1000;
    StringNode[] string = new StringNode[stringNodeLength];
    String result = "";
    int size; //the current longest palindrome's size
    public String longestPalindrome(String s) {
        for (int i=0; i<stringNodeLength; i++) {
            string[i] = new StringNode();
        }

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
        StringNode leftPointer;
        StringNode rightPointer;
        while (pointer != head ) {
            leftPointer = pointer;
            rightPointer = pointer;
            size=1;
            if (size > result.length()){
                result = BuildResultString(leftPointer, rightPointer);
            }
            result = SeekForPalindrome(leftPointer, rightPointer, size);
            pointer = pointer.next;
        }

        //seek for an even numbered palindrome
        pointer = head.next;
        size=0;
        while (pointer.next != head ){
            if (pointer.aChar == pointer.next.aChar){
                leftPointer = pointer;
                rightPointer = pointer.next;
                size = 2;
                if (size > result.length()){
                    result = BuildResultString(leftPointer, rightPointer);
                }
                result = SeekForPalindrome(leftPointer, rightPointer, size);
            }
            pointer = pointer.next;

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

    //seek for palindrome
    private String SeekForPalindrome(StringNode leftPointer, StringNode rightPointer, int size){
            while (leftPointer.previous != head && rightPointer.next != head ){
                if (leftPointer.previous.aChar == rightPointer.next.aChar){
                    size += 2;
                    leftPointer = leftPointer.previous;
                    rightPointer = rightPointer.next;
                    if (size > result.length()){
                        result = BuildResultString(leftPointer, rightPointer);
                    }

                } else{

                    break;
                }

            }
        return result;

    }
    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "ccc";
        System.out.println(longestPalindrome.longestPalindrome(s));


    }
}
