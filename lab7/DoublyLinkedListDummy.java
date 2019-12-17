package lab7;


public class DoublyLinkedListDummy {

    private DIntNode head;
    private DIntNode tail;

    
    //Q1 and Q3
    public DoublyLinkedListDummy() {
        head = new DIntNode();
        tail = new DIntNode();
        head.setNext(tail);
        tail.setPrev(head);

    }
    
    
    
    //Q2
    public DIntNode getHead() {
        return head;
    }

    public void setHead(DIntNode head) {
        this.head = head;
    }

    public DIntNode getTail() {
        return tail;
    }

    public void setTail(DIntNode tail) {
        this.tail = tail;
    }

    //Q4          Big O(n)
    public void addToEnd( int element ) {
    	DIntNode cursor = head;
    	while( cursor.getNext().getNext() != null ) {
    	cursor = cursor.getNext();
    	}
    	DIntNode newNode = new DIntNode( element, cursor, tail );
    	cursor.setNext(newNode);
    	tail.setPrev( newNode );

    	
    	}

    
    //Q5         Big O(n) 
    public void removeFromHead() {
        
        if(head != tail) {
            head.setNext(head.getNext().getNext());
            head.getNext().getNext().setPrev(head);
        }
        
    }
    
    //Q6 BigO  O(n)
        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();  
        int P = 0;
        String arrow = " <-> ";
        for(DIntNode cursor = head; cursor != null; cursor = cursor.getNext()){
            if(P == 0) {
                arrow = "";
                P++;
            }else if(P != 0) {
                arrow = " <-> ";
            }
            sb.append( arrow + cursor.getData() + "");
            }
            return sb.toString();
        }
        
    //Q7    BigO O(n)
        public int countOccurrence(int e) {
            
            int count = 0;
            for(DIntNode cursor = head; cursor != null; cursor = cursor.getNext( )) {
                
                if(cursor.getData() == e) {
                    count ++;
                }
                
            }
            
            return count;
            
            
        }

    //Q8      BigO O(n)
        public boolean removeAll(int e) {
            boolean truthVal = false;
            
            for(DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext( )) {
                
                if(cursor.getData() == e) {
                	cursor.getNext().setPrev(cursor.getPrev());
                	cursor.getPrev().setNext(cursor.getNext());
                    truthVal = true;
                }
                
            }
            return truthVal;
        }
        
    //Q9       BigO O(n)
        public DoublyLinkedListDummy subList( int beginIdx, int endIdx ) {
            DoublyLinkedListDummy myList = new DoublyLinkedListDummy();
            
            int length = 0; int placeHolder = 0;
            for(DIntNode cursor = head; cursor.getNext() != null; cursor = cursor.getNext( )) {
                if(cursor.getData() != 0) {
                	length++;
                }   
            }
            
            if((beginIdx < 0) || (beginIdx > length) || (beginIdx > endIdx))
                return null;
            else {
                for(DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext()) {
                    if((placeHolder >= beginIdx) && (placeHolder < endIdx)){
                        myList.addToEnd(cursor.getData());
                    }
                    placeHolder++;
                }
            }
            return myList;
        } 
        
        //Q10
        public void printStatistics() {
    		System.out.println("Number      Occurance");
    		int count = 0;
        	for(DIntNode cursor = head; cursor.getNext() != null; cursor = cursor.getNext( )) {
                for(int i = 1; i < 10000; i++ ) {
                	if(this.countOccurrence(i) > 0) {
                		count++;
                		System.out.println( cursor.getData() );
                		if(this.countOccurrence(i) == this.countOccurrence(i+1)) {
                    		System.out.println( count );
                		}
                	}
                	count = 0;
                }
            }
        	
        }
        
        //Q11
        public static void main(String args[]) {
            
            DoublyLinkedListDummy myList = new DoublyLinkedListDummy();
            DoublyLinkedListDummy mySecondList = new DoublyLinkedListDummy();
            DoublyLinkedListDummy myThirdList = new DoublyLinkedListDummy();

            
            myList.addToEnd(1); mySecondList.addToEnd(1); myThirdList.addToEnd(101);
            myList.addToEnd(2); mySecondList.addToEnd(2); myThirdList.addToEnd(102);
            myList.addToEnd(3); mySecondList.addToEnd(2); myThirdList.addToEnd(103);
            myList.addToEnd(4); mySecondList.addToEnd(3); myThirdList.addToEnd(104);
            myList.addToEnd(5); mySecondList.addToEnd(3); myThirdList.addToEnd(105);
            myList.addToEnd(6); mySecondList.addToEnd(3); myThirdList.addToEnd(106);
            myList.addToEnd(7); mySecondList.addToEnd(3); myThirdList.addToEnd(107);
            myList.addToEnd(8); mySecondList.addToEnd(4); myThirdList.addToEnd(108);
            myList.addToEnd(9); mySecondList.addToEnd(4); myThirdList.addToEnd(109);
            myList.addToEnd(10); mySecondList.addToEnd(4); myThirdList.addToEnd(110);
            
            System.out.println("");
            System.out.print("         My list: ");
            System.out.println(myList.toString());
            
            myList.removeFromHead();
            
            System.out.println("");
            System.out.print("Remove from head: ");
            System.out.println(myList.toString());
            
            System.out.println("");
            System.out.println("  My Second List: " + mySecondList.toString());
            System.out.print("Count Occurrence: "); int input = 3;
            System.out.println( mySecondList.countOccurrence(input) );
            System.out.println( "  For the number: " + input); 
            
            System.out.println("");
            System.out.println("  My Second List: " + mySecondList.toString()); int secondInput = 3;
            System.out.println("     Truth Value: " + mySecondList.removeAll(secondInput) ) ;
            System.out.println("      Remove all: " + mySecondList.toString() );
            System.out.println( "  For the number: " + secondInput); 
            
            System.out.println("");
            System.out.println("  My Third List: " + myThirdList.toString());
            System.out.println("        SubList: " + myThirdList.subList(3, 5));
            
            System.out.println("");
            mySecondList.printStatistics();
            
            
        }
        
    
}


