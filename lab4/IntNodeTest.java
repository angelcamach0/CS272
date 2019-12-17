
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
		
		//testing my search
		System.out.println("");
		System.out.println("Testing extra methods");

		
		
	}

}
