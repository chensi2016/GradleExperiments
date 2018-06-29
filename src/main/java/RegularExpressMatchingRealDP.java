public class RegularExpressMatchingRealDP {
    String s;
    String p;
    int[][] state;  //a state to record whether p and s match until s.charAt(i) and p.charAt(j). state[i][0] refers s[i] matches a blank p.
    // -1 initial
    // 0 not match
    // 1 match
    // 2 ignore

    public boolean isMatch (String s, String p) {
        this.s = s;
        this.p = p;
        state = new int[s.length() + 1][p.length() + 1];

        for (int i= 0; i<= s.length(); i++){
            for (int j = 0; j <= p.length(); j++){
                if ( i == 0 && j == 0 ) {
                    state[i][j] = 1; //refers to a blank s always matches a blank p
                }
                state[i][j] = -1; //the initial number is -2
            }
        }
        return match(s.length() - 1, s.length() - 1 );
    }

    private boolean match (int pointerForS, int pointerForP) {
        boolean compare;
        if ( state[pointerForS + 1][pointerForP +1 ] == 1 ) {
            return true;
        }

        if ( state[pointerForS +1 ][pointerForP +1] == -1 ) {
            return false;
        }

        if ( p.charAt(pointerForS) == '*' && ( s.charAt(pointerForS) == p.charAt(pointerForP -1) || p.charAt(pointerForP -1 ) == '.') ) {
            compare = true;
        }
        else {
            if ( p.charAt(pointerForS) == '.' ) {
                compare = true;
            }
            else {
                if ( s.charAt(pointerForS) == p.charAt(pointerForP) ) {
                    compare = true;
                }
                else
                    compare = false;
            }
        }

        if (   ) {

        }
        int pointerForCurrentP = pointerForP;
        while ( pointerForCurrentP - 1 >= 0 && p.charAt(pointerForCurrentP) != s.charAt(pointerForS)  ) {
            if ( p.charAt(pointerForCurrentP) == '*' p.charAt(pointerForCurrentP -1 ) != s.charAt(pointerForS) ) {
                compare = true;
                if ( match(pointerForS, pointerForP - 2 ) && compare ) {
                    state = [pointerForS + 1][pointerForP + 1] = 1;
                    state = [pointerForS + 1][pointerForP] = -1;
                    return true;

                }

            }
            else{
                if (p.charAt(pointerForCurrentP) == '*' p.charAt(pointerForCurrentP - 1) == s.charAt(pointerForS) ){
                    compare = true;
                    if (match(pointerForS, pointerForP - 2) && compare) {
                        state = [pointerForS + 1][pointerForP + 1] =1;
                        state = [pointerForS + 1][pointerForP] =-1;
                        return true;
                    }
                    break;
                    pointerForCurrentP = pointerForCurrentP - 2;


                }

            }
        if ( pointerForS - 1 >=0 &&  pointerForS -1 >=0 && match(pointerForS - 1, pointerForP - 1 ) && compare) {
            state =[pointerForS + 1][pointerForP + 1] = 1;
            return true;
        }
        else {
            state =[pointerForS + 1][pointerForP + 1] = -1;
            return false;
        }
    }
}
