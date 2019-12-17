public class RecursiveQuestion {


    public static int FibBinaryRecursive(int k) {
        if (k < 0 ) { return -1;}
        if ( k == 0 || k == 1 ) {
            return k;
        }
        return FibBinaryRecursive( k - 1 ) + FibBinaryRecursive( k - 2);

    }
    //2
    public static void HanoiTower( int n , String from, String to,String spare) {
        if (n == 0) {
            return;
        }
        if (n > 0) {
            HanoiTower( n - 1, from, spare, to);
            System.out.println("move disk " + n + " from " + from + " to " + to);
            HanoiTower(n-1, spare, to, from);
        }

    }

           // please ignore this
//    public static String showCallLevel(int L, int C){
//
//        String numSpaces = "";
//        String sentence = "This was written by call number ";
//
//        if( L <= 0 || C <= 0){
//            return "";
//        }
//        //System.out.println("I got here");
//        for(int i = 0; i < C; i ++){
//            //numSpaces = numSpaces + " ";
//                if( L == C) {
//                    System.out.print("\b");
//                    System.out.print(" ");
//                }
//                System.out.print(" ");
//        }
//        if( C <= L ){
//            System.out.println("This was written by call number" + C + "x.");
//            return showCallLevel( L, C + 1);
//        }
//        if( C > L ){
//            System.out.println("This was written by call number" + L + "y.");
//            return showCallLevel( L-1, C-1);
//        }
//        return showCallLevel(L-1, C + 1);
//    }

    //3
    public static String showCallLevel2(int L, int C){

        String numSpaces = "";
        if( L <= 0 || C <= 0) {
            return "";
        }
        for(int i = 0; i < C; i ++){
            numSpaces = numSpaces + " ";
        }
        if( C <= L ){
            return "\n" + numSpaces +" This was written by call number "+ C + "x." + showCallLevel2( L, C + 1) ;
        }
        if( C >= L ){
            return "\n"+ numSpaces +"This was written by call number "+ L + "y." + showCallLevel2( L-1, C-1);
        }
        return showCallLevel2(L-1, C + 1);
    }


    public static int BinaryPrint(int n){
        if( n == 0 ){
            return 0;
            //System.out.println(0000);
        }else{
            //System.out.print( n % 2 + 10);
            return n % 2 + 10 * BinaryPrint(n/2);
        }
    }

    public static void BinaryPrint2(int n){
        if( n <= 0 ){
            System.out.print(0);
            return;
        }
        if( n != 1){
            BinaryPrint2(n / 2);
        }
        System.out.print(n % 2 );
    }

    public static void fractal( int leftMost, int longestLine){
        if( longestLine == 0){
            return;
        }
        fractal(leftMost, longestLine / 2);
        int i = 0;
        while( i < leftMost){
            System.out.print("  ");
            i++;
        }
        i = 0;
        while( i < longestLine){
            System.out.print("* ");
            i++;
        }
        System.out.println();
        fractal(leftMost + longestLine / 2, longestLine / 2);
    }

    public static void main(String []args) {

        System.out.println(FibBinaryRecursive(5));
        HanoiTower(7,"A","C","B");

        //showCallLevel(4,1);
        System.out.println(showCallLevel2(4,1));

        BinaryPrint2(8);System.out.print("\n");
        BinaryPrint2(0);System.out.print("\n");
        BinaryPrint2(4);System.out.print("\n");
        BinaryPrint2(27);System.out.print("\n");
        System.out.print("\n");
        System.out.println("n=0 Output: 0\nn=4 Output: 100\nn=27 Output: 11011");

        System.out.print("\n");
        fractal(0,8);

    }



}
