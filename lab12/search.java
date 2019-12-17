public class search {
    public static int binarySearch(int[] A, int e){
        int end = A.length-1;
        int start = 0;
        int mid = (end+start)/2;

        while(!(start > end)){
            if(A[mid] == e) {
                return mid;
            }
            if(A[mid] < e){
                start = mid+1;
                mid = (end+start)/2;
            }
            if(A[mid] > e){
                end = mid-1;
                mid = (end+start)/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myArray = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Test six: "+binarySearch(myArray, 6));
        System.out.println("Test eleven: "+binarySearch(myArray, 11));
        System.out.println("Test three: "+binarySearch(myArray, 3));




    }

}
