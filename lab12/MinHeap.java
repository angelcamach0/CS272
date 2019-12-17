import java.util.ArrayList;
import java.util.Collections;
public class MinHeap {

    public ArrayList <Integer> myArrayList;

    public MinHeap(){
        myArrayList = new ArrayList<>();
    }

    public void add(int e){
        myArrayList.add(e);
        reHeapUpward(myArrayList.size()-1);
    }

    public void reHeapUpward(int pos){
        if(pos <= 0){
            return;
        }
        int parentPos = ((pos-1)/2);
        if( myArrayList.get(pos) > myArrayList.get(parentPos) ){
            Collections.swap(myArrayList,pos, parentPos);
        }
        reHeapUpward(parentPos);
    }

    public int remove(){
        if(myArrayList.size() == 0){ throw new IllegalCallerException("Its Empty!"); }
        int temp = top();
        myArrayList.remove(0);
        return temp;
    }



    public int top(){
        if(myArrayList.size() != 0){
            return myArrayList.get(0);
        }
        throw new IllegalCallerException("Theres nothing in the Heap");
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "myArrayList=" + myArrayList +
                '}';
    }

    public static void main(String args[]){

        MinHeap testOne = new MinHeap();
        MinHeap testTwo = new MinHeap();
        testOne.add(100);
        testOne.add(90);
        testOne.add(80);
        testOne.add(70);
        System.out.println("Testing top... "+ testOne.top());
        System.out.println(testOne);
        testOne.remove();
        System.out.println("Testing remove... " + testOne.top());
        System.out.println(testOne);

        try{
            testTwo.remove();
        }catch( Exception e ){
            System.out.println("The exception works!");
        }

        // in this step I added numbers back wards
        testTwo.add(70);
        testTwo.add(80);
        testTwo.add(90);
        testTwo.add(100);
        System.out.println(testTwo);
        testTwo.remove();
        System.out.println(testTwo);



    }

}
