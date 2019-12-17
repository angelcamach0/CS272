import java.util.*;
public class LinkStack<E> implements StackInterface<E>{

	private SNode<E> top; 
	
	public LinkStack(){
		top = null;
	}
	
	public void push(E e) {
		top = new SNode(e,top);
	}
	
	public E pop() {
		E x;
		
		if(top == null) {
			return null;
		}
		x = top.getData();
		top = top.getLink();
		return x;
	
	}
	
	public E top() {
		E x;
		
		if(top == null) { 
			return null;
		}else {
			x = top.getData();
		}
		return x;
	}
	
	public int size() {
		return SNode.listLength(top);
	}
	
	public boolean isEmpty() {
		if(top == null){
			return true;
		}
		return false;
	}
	
}
