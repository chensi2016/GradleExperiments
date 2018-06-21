public class RegularExpressMatchingDP {
    int pointerForS;
    int pointerForP;

    public boolean isMatch (String s, String p){
        pointerForP = 0;
        pointerForS = 0;
        return  match(s, p);

    }

    boolean match(String s, String p){
        boolean compareNext = false;
        //normal character vs normal character
        if( s.charAt(pointerForS) == p.charAt(pointerForP) && p.charAt(pointerForP) != '.' && p.charAt(pointerForP) != '*' ) {
            if( pointerForP < p.length() && p.charAt(pointerForP+1) == '*' ){
                while ( pointerForS < s.length() && ( p.charAt(pointerForP) == s.charAt(pointerForS) ) ) {
                    pointerForS++;
                }
                pointerForP = pointerForP + 2;
                compareNext = true;
            }
            else {

                if (pointerForS < s.length() && p.charAt(pointerForP + 1) == s.charAt(pointerForS + 1)) {
                    pointerForP++;
                    pointerForS++;
                    compareNext = true;
                }

                else {
                    if(pointerForS < s.length() && p.charAt(pointerForP) == '.') {
                        pointerForS++;
                        pointerForP++;
                        compareNext = true;
                    }
                }
            }

        }

        else {
            if(pointerForP < p.length() && p.charAt(pointerForP) == '.') {

                if (pointerForP < p.length() && p.charAt(pointerForP + 1) == '*') {
                    while (pointerForS < s.length()) {
                        pointerForS++;
                    }
                    pointerForP = pointerForP + 2;
                    compareNext = true;
                }
                else {
                    if (pointerForS < s.length() && p.charAt(pointerForP + 1) == s.charAt(pointerForS + 1)) {
                        pointerForP++;
                        pointerForS++;
                        compareNext = true;
                    }
                    else {


                        if (pointerForS < s.length() && p.charAt(pointerForP) == '.') {
                            pointerForS++;
                            pointerForP++;
                            compareNext = true;
                        }
                    }
                }
            }

            }
        if(pointerForS >= s.length() && pointerForP >= p.length() ){
            return true;
        }

        if ( pointerForS >= s.length() || pointerForP >= p.length() ) {
            return false;
        }

        if (match(s, p) && compareNext ) {
            return true;
        }

        return false;

    }
}
