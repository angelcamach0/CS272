import java.util.Arrays;

public class EmployeeSet {
	
	
		//instace variable
		private Employee[] data;
		private int cnt;
		
	
		//default constructor
		public EmployeeSet() {
			this.data = new Employee[10];
			this.cnt = 0;
		}
		
		//copy constructor
		public EmployeeSet(Object obj) {
			if(obj==null) 
				return;
			if(obj instanceof EmployeeSet) {
				EmployeeSet E2 = (EmployeeSet)obj;
				cnt = E2.cnt;
				this.data = new Employee[E2.data.length];
				System.arraycopy(E2.data, 0, this.data, 0, E2.cnt);
			}else {
				return;
			}
		}
		
		//checking how many employes are actually in the array
		public int size() {
			int count = 0;
			for(int i = 0; i < cnt; i++) {
				if(data[i] instanceof Employee){
					count ++;
				}
			}
			return count;
		}
		
		//return the capacity of array data
		public int capacity() {
			return data.length;
		} 
		
		//add draft
	    public void add (Employee e) {
	    	ensureCapacity(cnt+1);
	    	data [cnt] = e;
	    	cnt++;
		}
	    
	    //to check whether this collection contains the input parameter
	    public boolean contain(Employee a) {
	    	if(a == null) {
			return false;
			}
	    	else {
	    		for(int i = 0; i < cnt; i++) {
	    			if(data[i].equals(a)) {
	    				return true;
	    				}
	    		}
	    	}
	    	return false;
	    }
		
	    //search draft
	    public int search (int e) {
	    	int eCounter = 0;
	    	//for loop
	    	for (int i = 0; i< cnt; i++) {
	    		 if (e == data[i].getNo())
	    			eCounter++;
	    	}
	    	return eCounter;
	    }
	
	    //remove draft
	    public void remove(int eno){
	    	//loop
	    	for(int i = 0; i < cnt; i++) {
	    		if(eno == data[i].getNo()){
	    			data[i] = data[cnt-1];
	    			cnt--;
	    	
	    		}
	    		
	    	}
	    }
	    
	    //ensure capacity, still needs work
	    public void ensureCapacity(int minimumCapacity) {
	    	Employee[] biggerArray;
	    	
	    	if(data.length < minimumCapacity) {
	    		biggerArray = new Employee[minimumCapacity];
	    		System.arraycopy(data, 0, biggerArray, 0, cnt);
	    		data = biggerArray;
	    	}
	    }
	    
	    //add object to this EmployeeSet
	    public void addOrdered(Employee a) {

	    	for(int i = 0; i < cnt; i++) {
	    		if(a.getNo() <= data[i].getNo()) {
	    			moveToRight(i ,cnt ,data );
	    			ensureCapacity(cnt+1);
	    			data[i] = a;
	    			return;
	    		}
	    	}add(a);
	    	
	    }
	    
	    //public void filteredSet
	    
	    public void moveToRight(int index, int count, Employee []arr) {
	    	ensureCapacity(cnt+1);
	    	for(int i = (count); i > index; i--) {
	    		arr[i+1] = arr[i];
    		}
	    	cnt++;
	    }
	    
	    public static void main(String[]args){
	    	EmployeeSet groups1 = new EmployeeSet();
	    	EmployeeSet groups2 = new EmployeeSet(groups1);
	    	
			Employee John = new Employee();
			Employee Mike = new Employee();
			Employee Adam = new Employee();
			Employee Bob = new Employee();
			Employee Ryan = new Employee();
			
			
			Integer[] advisors0 = {3,2,1};
			Integer[] advisors1 = {1,4,5};
			
			John.setAdvisors(advisors0);John.setAge(30);John.setName("Johnny");John.setState("New York");John.setNo(1);John.setZipCode(880021);
			Mike.setAdvisors(advisors1);Mike.setAge(12);Mike.setName("Miguel");Mike.setState("New Mexico");Mike.setNo(2);Mike.setZipCode(153103);
			Adam.setAdvisors(advisors0);Adam.setAge(89);Adam.setName("Adam");Adam.setState("Texas");Adam.setNo(3);Adam.setZipCode(12356);
			Bob.setAdvisors(advisors1);Bob.setAge(54);Bob.setName("Bobby");Bob.setState("Kansas");Bob.setNo(4);Bob.setZipCode(115763);
			Ryan.setAdvisors(advisors1);Ryan.setAge(54);Ryan.setName("Bobby");Ryan.setState("Kansas");Ryan.setNo(5);Ryan.setZipCode(115763);
			
			groups1.add(John);
			groups1.add(Mike);
			

			
			
			System.out.println(groups1.toString());
			//testing copy constructor
	    	
			System.out.println(groups2.toString());
			
			//test size
			System.out.println("This is the size of the og group: "+groups1.size());
			System.out.println("This is the size of the copy: "+groups2.size());
			
			//test add method after coppy
			groups2.add(Adam);
			groups2.add(Bob);

			System.out.println("This is the size of the copy PLUS two worker: "+groups2.size());
			
			//testing Contain method
			System.out.println("Does the group2 contain the worker? "+groups2.contain(Bob));
			System.out.println("Does the group1 contain the worker? "+groups2.contain(John));

			//test search
			//System.out.println(""+groups2.search(57551));
			
			
			//test remove
			groups2.remove(John.getNo());
			System.out.println(groups2.toString());
			System.out.println("group2 size : "+groups2.size());
			
			//test add ordered Assuming they are already in order
			groups1.add(Ryan);
			groups1.addOrdered(Ryan);
			System.out.println(groups1.toString());
			System.out.println("group2 size : "+groups1.size());


			
	    }

		@Override
		public String toString() {
			return "EmployeeSet [data=" + Arrays.toString(data) + ", cnt=" + cnt + "]";
		}
		
		
	    
	    

}
