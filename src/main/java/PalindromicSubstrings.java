public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        for ( int i= 0; i < charArray.length; i++ ) {
            result++;
            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && right < charArray.length && charArray[left] == charArray[right])
            {
                result++;
                left--;
                right++;
            }
        }
        for ( int i= 0; i < charArray.length - 1; i++ ) {
            int left = i;
            int right = i + 1;
            while(left >= 0 && right < charArray.length && charArray[left] == charArray[right])
            {
                result++;
                left--;
                right++;
            }
        }
        return result;

    }
}
