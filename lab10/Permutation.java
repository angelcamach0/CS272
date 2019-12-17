
public class Permutation {
    public static void main(String[] args) {
        int[] myArray = {1,2,5,10};
        // when testing use the place holder of zero so it gives the most posssible combinations
        possibleCombinations(0,myArray);
    }
    public static void possibleCombinations(int placeHolder,int[] myArray) {
        if (placeHolder == myArray.length) {
            int i = 0;
            while( i < myArray.length){
                System.out.print(myArray[i] + " ");
                i++;
            }
            System.out.println();
        }
        int k = placeHolder;
        while ( k < myArray.length) {
            //switch
            int temporary = myArray[placeHolder];
            myArray[placeHolder] = myArray[k];
            myArray[k] = temporary;
            possibleCombinations(placeHolder + 1,myArray);
            //switch
            temporary = myArray[placeHolder];
            myArray[placeHolder] = myArray[k];
            myArray[k] = temporary;
            k++;
        }
    }
}
