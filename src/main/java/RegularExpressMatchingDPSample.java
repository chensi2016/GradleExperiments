public class RegularExpressMatchingDPSample {
        public boolean isMatch(String s, String p) {

            boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
            state[0][0] = true; // a blank s always matches a blank p

            //S is blank while P is not blank
            for ( int j = 1; j < p.length(); j++ ){
                if ( p.charAt(j) == '*' ){
                    state[0][j+1] = state[0][j-1];
                }

            }

           // P is blank while S is not blank
            for( int i = 1; i < s.length(); i++){
                state[i][0] = false;
            }

            for( int i = 0; i < s.length(); i++ ) {
                for (int j = 0; j < p.length(); j++) {
                    if ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        state[i+1][j+1] = state[i][j];
                    } else {
                        if ( p.charAt(j) == '*' ) {
                            state[i + 1][j + 1] = state[i + 1][j - 1];

                            if (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) {
                                state[i + 1][j + 1] |= state[i][j + 1];
                            }
                        }

                    }
                }
            }
            return state[s.length()][p.length()];

        }

}
