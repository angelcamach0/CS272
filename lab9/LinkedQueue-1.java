import java.util.EmptyStackException;

public class LinkedQueue<E> implements QueueInterface<E>{

    private SNode<E> front;
    private SNode<E> rear;
    private int manyItems;

    public LinkedQueue(){
        manyItems = 0;
        front = new SNode((E)new Object(),null);
        rear = front; // so they can both point at the same place
    }

    public void enqueue(E e){
        SNode <E>temp = new SNode(e,null);
        rear.setLink(temp);
        rear = rear.getLink();
        manyItems++;
    }



    public E dequeue(){
        E temp = front.getLink().getData();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        front.setLink(front.getLink().getLink());
        manyItems--;
        return temp;
    }

    @Override
    public E front() {
        return front.getData();
    }

    public int size() {
        return manyItems;
    }

    public boolean isEmpty(){
       return front.getLink() == null;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", manyItems=" + manyItems +
                '}';
    }
}
