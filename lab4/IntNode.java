
public class IntNode {
	
	//1
	private int data;
	private IntNode Link;
	
	//2
	public IntNode() {
		this.data = 0;
		Link = null;
	}
	
	//3
	public IntNode(int _data, IntNode _node){
		data = _data;
		Link = _node;
	}
	
	//4
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public IntNode getLink() {
		return Link;
		
	}

	public void setLink(IntNode link) {
		Link = link;
	}

	//5 DRAFT
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();  
	int P = 0;
	String arrow = " -> ";
	for(IntNode i = this; i != null; i = i.Link){
		if(P == 0) {
			arrow = "";
			P++;
		}else if(P != 0) {
			arrow = " -> ";
		}
		sb.append( arrow + i.data + " ");
		}
		return sb.toString();
	}
	
	
	//6 DRAFT
	public void addNodeAfterThis(int newdata) {
		this.Link = new IntNode(newdata, this.Link);
	}
	
	//7 DRAFT
	public void removeNodeAfterThis() {
		this.Link = this.getLink().getLink();
	}
	
	/**
	 * @param head what Node is it looking at?
	 * @return returns the length of the node
	 */
	//8
	public static int listLength(IntNode head) {
		int listLength = 0;
		for(IntNode i = head; i != null; i = i.Link ){
			listLength++;
		}
		return listLength;
	}
	
//	//  my search
//	public static int valSearch(IntNode head, int data) {
//		int counter = 0;
//		for(IntNode i = head; i != null; i = i.Link){
//			if(i.getData() == data) {
//				break;
//			}
//			counter++;
//		}
//		if(counter == listLength(head)) {
//			return -1;
//		}
//		return counter;
//	}

	/**
	 * @precondition not Null
	 * @param head what Node is it looking at?
	 * @param data value that it is looking for
	 * @return returns weather its there or not as a boolean
	 */
	
	public static boolean search(IntNode head, int data) {
		boolean search = false;
		for(IntNode i = head; i != null; i = i.Link){
			if(i.getData() == data) {
				search = true;
				break;
			}
		}
		return search;
	}
	
}
