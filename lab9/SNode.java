
public class SNode<E>{
	
	private E data;
	private SNode<E> link;
	
	public SNode(E data, SNode<E> link){
		this.data = data;
		this.link = link;
	}

	
	
	public E getData() {
		return data;
	}

	public void setData(E data2) {
		data = data2;
	}

	public SNode<E> getLink() {
		return link;
	}

	public void setLink(SNode<E> link2) {
		link = link2;
	}
	
	public static int listLength(SNode head) {
		int listLength = 0;
		for(SNode i = head; i != null; i = i.link ){
			listLength++;
		}
		
		return listLength;
	}
	
	
	

	

	
}
