public class RegularExpressMatchingRealDP {
    String s;
    String p;
    int[][] state;  //a state to record whether p and s match until s.charAt(i) and p.charAt(j). state[i][0] refers s[i] matches a blank p.
    // -1 initial
    // 0 not match
    // 1 match

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        state = new int[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                state[i][j] = -1; //the initial number is -1
            }
        }
        state[0][0] = 1;//refers to a blank s always matches a blank p

        return match(s.length() - 1, p.length() - 1);
    }

    private boolean match(int pointerForS, int pointerForP) {

        if ( state[pointerForS + 1][pointerForP + 1] != -1 ) {
            return state[pointerForS + 1][pointerForP + 1] == 1 ? true:false;
        }

        //S is blank while P is not blank
        if ( pointerForS == -1 ) {
            if (pointerForP - 1 >= 0  && p.charAt(pointerForP) == '*' ) {
                if ( match(pointerForS, pointerForP - 2) ) {
                    state[pointerForS + 1][pointerForP + 1] = 1;
                    state[pointerForS + 1][pointerForP] = 0;
                    return true;

                }else{
                    state[pointerForS + 1][pointerForP + 1] = 0;
                    state[pointerForS + 1][pointerForP] = 0;
                    return false;
                }

            }
            else{
                state[pointerForS + 1][pointerForP + 1] = 0;
                return false;

            }
        }

        //P is blank while S is not blank
        if ( pointerForP == -1 )
        {
            state[pointerForS + 1][pointerForP + 1] = 0;
            return false;
        }

        if (p.charAt(pointerForP) == '.' || s.charAt(pointerForS) == p.charAt(pointerForP) ) {
            if ( match(pointerForS - 1, pointerForP - 1) ) {
                state[pointerForS + 1][pointerForP + 1] = 1;
                return true;
            } else {
                state[pointerForS + 1][pointerForP + 1] = 0;
                return false;
            }
        }else{
            if ( p.charAt(pointerForP) == '*' && p.charAt(pointerForP - 1) != s.charAt(pointerForS) && p.charAt(pointerForP - 1) != '.') {
                if ( match(pointerForS, pointerForP - 2) ) {
                    state[pointerForS + 1][pointerForP + 1] = 1;
                    state[pointerForS + 1][pointerForP] = 0;
                    return true;

                }
                else {
                    state[pointerForS + 1][pointerForP + 1] = 0;
                    return false;
                }

            }else {
                if ( p.charAt(pointerForP) == '*' && (p.charAt(pointerForP - 1) == '.'|| s.charAt(pointerForS) == p.charAt(pointerForP - 1) )) {
                    if ( match(pointerForS, pointerForP - 2) ) {
                        state[pointerForS + 1][pointerForP + 1] = 1;
                        return true;
                    } else{
                        if ( match(pointerForS-1, pointerForP) ) {
                            state[pointerForS + 1][pointerForP + 1] = 1;
                            return true;
                        }else {
                            state[pointerForS + 1][pointerForP + 1] = 0;
                            return false;
                        }

                    }
                }
                else{
                    state[pointerForS + 1][pointerForP + 1] = 0;
                    return false;
                }
            }

        }

    }
}
