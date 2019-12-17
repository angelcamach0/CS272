
public class StackTest {
	public static void main(String args[]) {
		LinkStack aList = new LinkStack();
		LinkStack bList = new LinkStack();
		
		System.out.println("");
		System.out.println("Testing is top: ");
		aList.push("one");
		System.out.println(aList.top());
		aList.push(2);
		System.out.println(aList.top());
		aList.push("three");
		System.out.println(aList.top());
		aList.push(4f);
		System.out.println(aList.top());
		
		System.out.println("This is the size: "+ aList.size());
		
		System.out.println("After pop:");
		aList.pop();
		System.out.print(aList.top());
		
		System.out.println("Is it aList empty? "+aList.isEmpty());
		System.out.println("Is it bList empty? "+bList.isEmpty());
		
		ArraylistStack aArray = new ArraylistStack();
		ArraylistStack bArray = new ArraylistStack();
		
		aArray.push("whatever you want");
		System.out.println(aArray.top());
		aArray.push('A');
		aArray.push('N');
		aArray.push('G');
		aArray.push('E');
		aArray.push('L');
		aArray.push("is weird!");
		aArray.push(32);
		aArray.push(666);
		aArray.push("matame");
		aArray.push(13);
		System.out.println("");
		System.out.println("Testing is Size");
		System.out.println("This is the size: "+ aArray.size());
		System.out.println("This is the size: "+ bArray.size());
		aArray.pop();
		System.out.println(aArray.top());
		
		System.out.println("");
		System.out.println("Testing is empty");
		System.out.println("Is it aArray empty? "+aArray.isEmpty());
		System.out.println("Is it bArray empty? " + bArray.isEmpty());

		
		


		
		

		
		
	}
}
