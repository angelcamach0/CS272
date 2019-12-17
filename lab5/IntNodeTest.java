package lab5;

public class IntNodeTest {


	public static void main(String[] args) {
		IntNode example = new IntNode();
		
		//test set and add
		example.setData(1);
		example.addNodeAfterThis(2);
		
		//test getLink and addNode After This
		example.getLink().addNodeAfterThis(3);
		example.getLink().getLink().addNodeAfterThis(4);
		example.getLink().getLink().getLink().addNodeAfterThis(5);
		example.getLink().getLink().getLink().getLink().addNodeAfterThis(6);
		example.getLink().getLink().getLink().getLink().getLink().addNodeAfterThis(7);
		example.getLink().getLink().getLink().getLink().getLink().getLink().addNodeAfterThis(7);
		example.getLink().getLink().getLink().getLink().getLink().getLink().getLink().addNodeAfterThis(7);
		System.out.println("");
		System.out.println("TESTING TO STRING");
		System.out.println(example.toString());
		
		//test remove
		example.getLink().getLink().getLink().getLink().removeNodeAfterThis();
		System.out.println("");
		System.out.println("TESTING TO STRING");
		System.out.println(example.toString());
		System.out.println("");
		System.out.println("TESTING SEARCH");
		System.out.println(IntNode.search(example, 4));
		System.out.println(IntNode.search(example, 100));
		System.out.println("");
		System.out.println("TESTING LISTLENGTH");
		System.out.println(IntNode.listLength(example));
		
		//test set link
		example.setLink(example.getLink().getLink());
		System.out.println("");
		System.out.println("TESTING TO STRING & GETLINK");
		System.out.println(example.toString());
		
		//________________________________________________________________________________________
		//_______________________________testing lab5 methods_____________________________________
		//________________________________________________________________________________________
		System.out.println("");
		System.out.println("__________________Testing Lab 5 methods______________________");
		
		System.out.println("");
		System.out.println("TESTING LISTEVENNUMBERS");
		System.out.println(IntNode.listEveneNumber(example));
		System.out.println("");
		System.out.println("TESTING ADD TO END");
		example.addToEnd(12);
		System.out.println(example.toString());
		
		System.out.println("");
		System.out.println("TESTING SUM TO LAST");
		System.out.println(IntNode.sumLast(example, 2));
		
		System.out.println("");
		System.out.println("TESTING METHOD LIST COPY");
		System.out.println(IntNode.copyOdd(example));
		
		System.out.println("");
		System.out.println("TESTING REMOVE ALL");
		System.out.println(IntNode.removeAll(example, 7));
		
		System.out.println("");
		System.out.println("TESTING REVERSE");
		System.out.println(IntNode.reverse(example));
		
		System.out.println("");
		System.out.print("TESTING CYCLE: ");
		System.out.println(IntNode.hasCycle(example));
		example.getLink().getLink().getLink().getLink().setLink(example);
		System.out.print("TESTING CYCLE WHEN IS A CIRCULAR LINKED LIST: ");
		System.out.println(IntNode.hasCycle(example));
		
		
		
		//example.addToEnd();
		
		
	}

}