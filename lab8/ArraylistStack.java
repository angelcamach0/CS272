
public class ArraylistStack<E> implements StackInterface<E> {
	private E[] arraylist;
	private int top;

	public ArraylistStack() {
		arraylist = (E[]) new Object[10];
		top = 0;
	}

	public void push(E e) {
		if(top == arraylist.length) {
			ensureCapacity(arraylist.length * 2);
	
		}
		arraylist[top] = e;
		top++;

	}

	public E pop() {
		E x;
		if(top == 0) {
			return null;
		}
		x = arraylist[--top]; 
		arraylist[top] = null;
		return x;
	}

	public E top() {
		if(top == 0) {
			return null;
		}
		
		return (E)arraylist[top-1];
		
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}

	public void ensureCapacity(int min) {
		if (arraylist.length < min) {
			E[] biggerlist;

			biggerlist = (E[]) new Object[arraylist.length * 2];

			System.arraycopy(arraylist, 0, biggerlist, 0, top);
			arraylist = biggerlist;
			
		}
	}
}
