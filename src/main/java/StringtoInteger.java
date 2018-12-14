public class StringtoInteger {
    public int myAtoi(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean positive = true;
        long num = 0;
        for ( char c : str.toCharArray() ) {
            if ( stringBuilder.length() != 0 && !(c >= '0' && c <= '9') ) {
                break;
            }
            if ( c == ' ') {
                continue;
            }
            if ( !(c == '+' || c == '-' ) && ( c < '0' || c > '9' ) ) {
                return 0;
            }
            if ( c == '+' || c == '-') {
                stringBuilder.append(c);
                if ( c == '-') {
                    positive = false;
                }
                continue;
            }
            if ( c >= '0' && c <= '9') {
                stringBuilder.append(c);
                num = 10 * num + (c - '0');
                if ( num > Integer.MAX_VALUE ) {
                    if (positive == true ) {
                        return Integer.MAX_VALUE;
                    }
                    if (positive == false ) {
                        return Integer.MIN_VALUE;
                    }
                }
            }
        }

        if ( stringBuilder.length() == 0 ) {
            return 0;
        }
        if ( positive == false ) {
            num = 0 - num;
        }
        return (int)num;

    }
}
