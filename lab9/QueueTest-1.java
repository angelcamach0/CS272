public class QueueTest {
    public static void main(String args[]){
        ArrayQueue <Integer> test1 = new <Integer>ArrayQueue();
        LinkedQueue <Integer>test2 = new <Integer>LinkedQueue();

        System.out.println("\n  Testing Linked Queue...  \n");
        for(int i = 0; i < 10; i++){
            test2.enqueue(i);
        }
        System.out.println(test2);
        for(int i = 0; i < 10; i ++){
            test2.dequeue();
        }
        System.out.println(test2);
        System.out.println("Is liked queue empty? " + test2.isEmpty());

        System.out.println("\n  Testing Array Queue,,,  \n");
        for(int i = 0; i < 10; i++){
            test1.enqueue(i);
        }
        System.out.print(test1 + "\n Testing another one.. \n");
        test1.enqueue(11); System.out.print(test1);
        System.out.print("\nDequeing all elements...\n");
        for(int i = 0; i < 8; i++){
            test1.dequeue();
        }
        System.out.print(test1);
//        for(int i = 0; i < 1; i++){
//            test1.enqueue(i);
//        }




    }
}
