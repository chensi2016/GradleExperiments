public class RegularExpressMatchingDPRewrite {

    int[][] state = new int[1000][1000];  //a state to record whether p and s match until p.charAt(i) and s.charAt(j). state[i][0] refers p[i] matches a blank S.
    // -2 initial
    // 1 match
    // -1 not match
    //  2 ignore

    int pointerForS = 0;
    int pointerForP = 0;

    public boolean isMatch (String s, String p){

        int lengthS = s.length();
        int lengthP = p.length();

        for (int i= 0; i< lengthP; i++){
            for (int j = 0; j <= lengthS; j++){
                state[i][j] = -2; //the initial number is -2
            }
        }

        return  match(s, p);


  }

  private boolean match(String s, String p){

      int lengthS = s.length();
      int lengthP = p.length();


      if ( pointerForP < lengthP-1 && p.charAt(pointerForP+1) == '*' ){
          for( int j = 0; j  <= lengthS; j++ ){
              state[pointerForP][j] = 2;
          }
          state[pointerForP+1][pointerForS] = 1;

          if ( p.charAt(pointerForP) == '.' ){
              while ( pointerForS < lengthS ) {
                  state[pointerForP + 1][pointerForS + 1] = 1;
                  pointerForS++;
              }

          }
          else {


              while (pointerForS < lengthS && s.charAt(pointerForS) == p.charAt(pointerForP)) {
                  state[pointerForP + 1][pointerForS + 1] = 1;
                  pointerForS++;
              }
          }
          pointerForP = pointerForP + 2;
      }
      else {
          if ( pointerForP < lengthP && p.charAt(pointerForP) == '.'){
              if ( pointerForS < lengthS ) {
                  //state[pointerForP][pointerForS+1] = 1;
                  pointerForP++;
                  pointerForS++;
              }
              else{
                  return false;
              }
          }
          else {
              if ( pointerForP < lengthP  ){
                  if (pointerForS < lengthS && s.charAt(pointerForS) == p.charAt(pointerForP)) {

                     // state[pointerForP][pointerForS+1] = 1;
                      pointerForP++;
                      pointerForS++;
                  }else{
                      state[pointerForP][pointerForS+1] = -1;
                      return false;
                  }
              }
              else {
                  return false;
              }
          }

      }

      if ( pointerForP == lengthP && pointerForS == lengthS ){
          return true;

      }

      if( match(s,p) ){
          return true;
      }
      else{

        //  while( ){}

          int pointerForCurrentP = pointerForP;
          int pointerForPreviousP = pointerForP;
          int pointerForCurrentS = pointerForS;
          int pointerForPreviousS = pointerForS;

          while ( pointerForCurrentS -1  >= 0  && pointerForCurrentP - 2 >= 0  ){

              if ( state[pointerForCurrentP-1][pointerForCurrentS] == 1 ) {
                  if ((s.charAt(pointerForCurrentS - 1) == p.charAt(pointerForCurrentP - 2)) || (p.charAt(pointerForCurrentP - 2) == '.')) {
                      pointerForS--;
                      pointerForCurrentS--;
                      if (match(s, p)) {
                          return true;
                      }
                  }
              }

              pointerForP = pointerForPreviousP;
              pointerForCurrentP = pointerForPreviousP;
              pointerForS = pointerForCurrentS;

          }
      }

      return false;



  }



}
