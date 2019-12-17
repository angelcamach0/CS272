package lab5;

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
	
	//________________________________________________________________________________________
	//_______________________________testing lab5 methods_____________________________________
	//________________________________________________________________________________________
	
	//1
	/**
	 * 
	 * @param head
	 * @return the number of even numbers
	 */
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
	/**
	 * 
	 * @param newdata adds new data to the end
	 */
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
	/**
	 * 
	 * @param head
	 * @param num how many time you want to add from the given number
	 * @return sumation depending on num
	 */
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
	/**
	 * 
	 * @param head
	 * @return the list of the copied odd
	 */
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
	//5
	/**
	 * 
	 * @param head 
	 * @param e is what you want to remove
	 * @return the new list with the removed elements
	 */
	public static IntNode removeAll(IntNode head,int e) {
		
		IntNode NEW = new IntNode(0,head);
		IntNode i = NEW;
		
		while( i.Link != null) {
			if(i.Link.getData() == e) {
				i.removeNodeAfterThis();
				if(i.getLink() == null) {
					break;
				}
			}else {
			 i = i.Link;
			}
		}
		return NEW.Link;
	}
	//6
	/**
	 * 
	 * @param head
	 * @return reversed Linked list
	 */
	public static IntNode reverse(IntNode head) {
		
		int array[] = new int[IntNode.listLength(head)];
		IntNode NEWLIST;
		//IntNode copyTail;
		 
		if(head == null) {
			return null;
		}
		 
		NEWLIST = new IntNode(0, null);
		 
		int counter = 0;
		IntNode cursor = head; 
		
		//basically turns linked list into array backwards
		while(counter < listLength(head)) {
			 
			array[counter] = cursor.getData();
			counter++;
			cursor = cursor.Link; 
		 }
		
		int counter2 = array.length;
		
		//turns array into linked list
		while(counter2 > 0 ) {
			
			NEWLIST.addToEnd(array[counter2-1]);
			counter2--;
		}
		 return NEWLIST.getLink();
		
	}
	
	//7
	/**
	 * 
	 * @param head
	 * @return returns weather is a cycle or not a cycle
	 */
	public static boolean hasCycle(IntNode head) {
		
		if(head == null) {
			return false;
		}
		
		for(IntNode i = head.Link; i.getLink() != null; i = i.Link ) {
			if(i.getLink() == head.Link) {
			return true;
			}
		}
		return false;
	}
}
