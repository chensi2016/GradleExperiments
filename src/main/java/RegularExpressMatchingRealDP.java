public class RegularExpressMatchingRealDP {
    String s;
    String p;
    int[][] state;  //a state to record whether p and s match until s.charAt(i) and p.charAt(j). state[i][0] refers s[i] matches a blank p.
    // -1 initial
    // 0 not match
    // 1 match
    // 2 ignore

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        state = new int[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    state[i][j] = 1; //refers to a blank s always matches a blank p
                }
                state[i][j] = -1; //the initial number is -1
            }
        }
        return match(s.length() - 1, p.length() - 1);
    }

    private boolean match(int pointerForS, int pointerForP) {
        boolean compare = false;
        if (state[pointerForS + 1][pointerForP + 1] == 1) {
            return true;
        }

        if (state[pointerForS + 1][pointerForP + 1] == 0) {
            return false;
        }

        if ( pointerForS < 0 && pointerForP < 0) {
            return true;
        }

        if ( pointerForS < 0 ) {
            if (pointerForP - 1 >= 0  && p.charAt(pointerForP) == '*' ) {
                compare = true;
                if (match(pointerForS, pointerForP - 2) && compare) {
                    state[pointerForS + 1][pointerForP + 1] = 1;
                    state[pointerForS + 1][pointerForP] = 0;
                    return true;

                }else{
                    return false;
                }

            }
            else{
                return false;

            }
        }

        if ( pointerForP < 0 )
        {
            return false;
        }


        if ( pointerForP-1 >= 0 && p.charAt(pointerForP) == '*' && pointerForS>=0 && (p.charAt(pointerForP - 1) == '.'|| s.charAt(pointerForS) == p.charAt(pointerForP - 1) )) {
            while ( pointerForS >= 0 && (p.charAt(pointerForP - 1) == '.'|| s.charAt(pointerForS) == p.charAt(pointerForP - 1)) ) {
                compare = true;

                if ( match(pointerForS, pointerForP - 2 ) && compare == true){
                    state[pointerForS + 1][pointerForP + 1] = 1;
                    state[pointerForS + 1][pointerForP] = 0;
                    return true;
                }
                pointerForS--;
            }
            pointerForP = pointerForP - 2;
            if ( match(pointerForS, pointerForP)) {
                state[pointerForS + 1][pointerForP + 1] = 1;
                return true;
            }
            else {
                state[pointerForS + 1][pointerForP + 1] = 0;
                return false;
            }



        } else {
            if (p.charAt(pointerForP) == '.') {
                compare = true;
            } else {
                if (s.charAt(pointerForS) == p.charAt(pointerForP)) {
                    compare = true;
                }
                else{
                     if (pointerForP - 1 >= 0  && p.charAt(pointerForP) == '*' && p.charAt(pointerForP - 1) != s.charAt(pointerForS)) {
                            compare = true;
                            if (match(pointerForS, pointerForP - 2) && compare) {
                                state[pointerForS + 1][pointerForP + 1] = 1;
                                state[pointerForS + 1][pointerForP] = 0;
                                return true;

                            }
                            else {
                                state[pointerForS + 1][pointerForP + 1] = 0;
                                return false;
                            }

                        }
                }
            }
        }

        if (match(pointerForS - 1, pointerForP - 1) && compare) {
            state[pointerForS + 1][pointerForP + 1] = 1;
            return true;
        } else {
            state[pointerForS + 1][pointerForP + 1] = 0;
            return false;
        }

    }
}
