public class RegularExpressMatching {
    public boolean isMatch (String s, String p) {
        int pointerForS = 0;
        int pointerForP = 0;
        char previousChar = ' ';

        while ( pointerForS < s.length() && pointerForP < p.length() ){
            if( pointerForP < p.length() -1 ) {
                if ( p.charAt(pointerForS) == '.' && p.charAt(pointerForP + 1) == '*' && pointerForP==p.length()-1) {
                    return true;
                }
            }

            if ( p.charAt(pointerForP) == '*' ) {
                int count = 0;
                    while ( pointerForS < s.length() && (previousChar == s.charAt(pointerForS) || previousChar == '.') ) {
                        count++;
                        pointerForS++;
                        if (pointerForS >= s.length() && pointerForP >= p.length())
                            return true;
                    }
                    count++;
                  do{
                        pointerForP++;

                        if (  (pointerForP < p.length() && p.charAt(pointerForP) != s.charAt(pointerForS) && p.charAt(pointerForP + 1) == '*') ) {
                            pointerForP = pointerForP + 2;
                        }
                        count--;

                    }
                  while( ( pointerForP < p.length()) && count != 0 && ( p.charAt(pointerForP) == previousChar ) );
                  continue;
            } else {
                if (p.charAt( pointerForP ) == '.' || p.charAt( pointerForP )== s.charAt( pointerForS) ) {
                    previousChar = p.charAt( pointerForP );
                    pointerForP++;
                    pointerForS++;
                }
                else
                {
                    if ( pointerForP < p.length() -1 ) {
                        if (p.charAt(pointerForP) != s.charAt(pointerForS) && p.charAt(pointerForP + 1) == '*')
                            pointerForP = pointerForP +2 ;
                    }
                    else{
                        if( p.charAt(pointerForP) != s.charAt(pointerForS) )
                            return false;
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
        else {
            return true;
        }

    }
}
