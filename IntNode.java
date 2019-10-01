
public class IntNode {
	
	//1
	private int data;
	private IntNode Link;
	

	public IntNode() {
		this.data = 0;
		Link = null;
	}
	
	public IntNode(int _data, IntNode _node){
		data = _data;
		Link = _node;
	}
	
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
	
	
	public void addNodeAfterThis(int newdata) {
		this.Link = new IntNode(newdata, this.Link);
	}
	
	
	public void removeNodeAfterThis() {
		this.Link = this.getLink().getLink();
	}
	
	/**
	 * @param head what Node is it looking at?
	 * @return returns the length of the node
	 */

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
	
	// Start of Lab Five
	
	//1
	public static int listEveneNumber(IntNode head) {
		int count = 0;

		for(IntNode i = head; i != null; i = i.Link) {
			if((i.getData() % 2) == 0) {
				count++;
			}
		}
		return count;
	}
	//2
	public void addToEnd(int newdata) {
		
		int counter = listLength(this);
		int k = 0;
		IntNode l = this;
		
		for(k = 0; k < counter; k++) {
			
			if(l.Link == null) {
				l.Link = new IntNode(newdata, l.Link);
			}
			l = l.Link;
		}

	}
	
	
	//3
	public static int sumLast(IntNode head, int num) {
		int sum = 0;
		int counterForSize = 0;
		
		for(IntNode i = head; i != null; i = i.Link) {
			sum = sum + i.getData();
			counterForSize++;
		}
		
		int opositeNum = counterForSize - num;
		int contraSum=0;
		int another=0;
		for(IntNode i = head; i != null; i = i.Link) {
			if(another<opositeNum) {
				contraSum = contraSum + i.getData();
			}
			another++;
		}
		sum = sum - contraSum;
		
		return sum;
	}
	//4
	public static IntNode copyOdd(IntNode head) {
		 IntNode copyHead;
		 IntNode copyTail;
		 
		 if(head == null) {
			 return null;
		 }
		 
		 copyHead = new IntNode(head.data, null);
		 copyTail = copyHead;
		 
		 while(head.Link != null) {
			 head = head.Link;
			 if((head.getData() % 2) != 0) {
				 copyTail.addNodeAfterThis(head.data);
				 copyTail = copyTail.Link;
			 }
			 
		 }
		 
		 return copyHead;
	}
//	//5
	public static IntNode removeAll(IntNode head,int e) {
		if(head.getData() == e) {
			head.removeNodeAfterThis();
		}
		for(IntNode i = head; i.Link != null; i = i.Link) {

			if(i.Link.getData() == e) {
				i.removeNodeAfterThis();
				if(i.getLink() == null) {
					break;
				}
			}
		}
		return head;
	}
//	//6
//	public static IntNode Reverse(IntNode head) {
//		
//	}
	//7
	public static boolean hasCycle(IntNode head) {
		return true;
	}
}
