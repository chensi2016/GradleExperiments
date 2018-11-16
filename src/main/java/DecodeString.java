public class DecodeString {
    public String decodeString(String s) {
        if (s.equals("")) {
            return s;
        }
        int firstLeftBracketIndex = 0;
        int firstRightBracketIndex = 0;
        int count = 0;
        for ( int i = 0 ; i < s.length(); i++ ) {
            if ( s.charAt(i) == '[' && count == 0) {
                firstLeftBracketIndex = i;
                count++;
                continue;
            }
            if ( s.charAt(i) == '[' ) {
                count ++;
                continue;
            }
            if ( s.charAt(i) == ']'  && count >= 2 ) {
                count--;
                continue;
            }
            if ( s.charAt(i) == ']'  && count == 1 ) {
                firstRightBracketIndex = i;
                count--;
                break;
            }

        }
        String result = "";
        if(s.charAt(0) >'9' && firstLeftBracketIndex == 0) {
            return s;
        }
        if(s.charAt(0) >'9' && firstLeftBracketIndex != 0) {
            result = result + s.substring(0, firstLeftBracketIndex).replaceAll("[0-9]","");
        }

        int number = Integer.valueOf(s.substring(0, firstLeftBracketIndex).replaceAll("[^0-9]",""));
        for (int i = 0; i < number; i++) {
            result = result + decodeString(s.substring(firstLeftBracketIndex + 1, firstRightBracketIndex));
        }
        if ( firstRightBracketIndex < s.length() -1 ) {
            result = result + decodeString(s.substring(firstRightBracketIndex + 1, s.length()));
        }
        return result;
    }
}
