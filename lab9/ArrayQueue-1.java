import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue<E> implements QueueInterface<E>{

    //instace variables
    private int front;
    private int rear;
    private E[] data;
    private int size;

    //constructors
    public ArrayQueue() {
        data = (E[]) new Object[10];
        front = 0;
        rear = 0;
        size = 0;
    }

    //methods
    public void enqueue(E e) {
        if( size != data.length ) {
            data[rear] = e;
            rear++; size++;
        }else {
            E[] newData = (E[]) new Object[size * 2];
            if(rear == data.length-1){
                if(front > 0){
                    if(front == rear && !isEmpty()){
                        //special copy
                        System.arraycopy(data, front, newData,0, size-front);
                        System.arraycopy(data, 0, newData, size-front,size-(size-front));
                        front = 0;
                        rear = size++;
                        size++;
                        data = newData;
                        data[rear] = e;
                    }
                    System.arraycopy(data, front, newData, 0, size);
                    data = newData;
                    data[rear] = e;
                    size++; rear++;
                }
            }
            System.arraycopy(data, front, newData, 0, size); // need to fix copy
            data = newData;
            data[rear] = e;
            front = 0;
            rear = data.length;
        }
    }


    // dequeue
    public E dequeue() {
        if (size != 0) {
            E ans = data[front];
            front++;
            size--;
            return ans;
        }
            throw new EmptyStackException();
    }

    // front
    public E front() {
        if (size != 0) {
            return data[0];
        }else {
            throw new EmptyStackException();
        }
    }

    // size
    public int size() {
        return size;
    }

    // isEmpty
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
