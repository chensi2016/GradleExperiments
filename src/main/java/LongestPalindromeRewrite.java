public class LongestPalindromeRewrite {
    private String result = "";
    public String longestPalindrome(String s){
        for(int i = 0; i < s.length(); i++){
            result = seekForPalindrome(s, i, i);
            if( i< s.length()-1) {
                result = seekForPalindrome(s, i, i + 1);
            }
        }

        return result;
    }
    private String seekForPalindrome(String s, int left, int right){
        int size;
        while (left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            size = right-left+1;
            if(size>result.length()) {
                result = s.substring(left, right + 1);
            }
            left--;
            right++;

        }
        return result;
    }
}
