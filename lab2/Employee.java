	import java.util.Arrays;
	//import org.apache.commons.lang.ArrayUtils;

	public class Employee {
		private String name;
		private int no;
		private int age;
		private String state;
		private int zipCode;
		private Integer[] advisors = new Integer[3];
		
		//my stuff
		static int count;
		//static Integer[] temporary = new Integer[count];
		
		public Employee() {
			this.name = null;
			this.no = 0;
			this.age = 0;
			this.state = null;
			this.zipCode = 0;
			this.advisors = null;
		}
		
		public Employee(Object obj) {
			if(obj==null) 
				return;
			if(obj instanceof Employee) {
				Employee E = (Employee)obj;
				name = E.name;
				no = E.no;
				age = E.age;
				state = E.state;
				zipCode = E.zipCode;
				advisors = E.advisors;
				
			}else {
				return;
			}
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getZipCode() {
			return zipCode;
		}

		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}

		public Integer[] getAdvisors() {
			return advisors;
		}

		public void setAdvisors(Integer[] advisors) {
			this.advisors = advisors;
		}

		//----
		@Override
		public String toString() {
			return "Employee [name=" + name + ", no=" + no + ", age=" + age + ", state=" + state + ", zipCode=" + zipCode
					+ ", advisors=" + Arrays.toString(advisors) + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (no != other.no)
				return false;
			return true;
		}
		
		//--
		
		public static Integer[] getAllAdvisors(Employee e1, Employee e2) {		
			Integer mergedList[] = new Integer[6]; //e1.getAdvisors().length+e2.getAdvisors().length
			
			int count = 0;
			//merge
			for (int i = 0; i < 3; i++) { //e1.getAdvisors().length
				mergedList[i] = e1.getAdvisors()[i];
				count++;
			}
			for (int i = 0; i < 3; i++) { //e2.getAdvisors().length
				mergedList[count] = e2.getAdvisors()[i];
				count++;
			}
			//return mergedList;
			return Employee.filtered(mergedList);
		}
		
		public static Integer[] filtered(Integer[]mergedList) {
			int l = mergedList.length;
			
			//first bubble sort
			for(int i = 0; i < l-1; i++) {
				for(int j = 0; j < l-1; j++) {
					if(mergedList[j]<mergedList[j+1])
					{
						Integer forNow = mergedList[j];
						mergedList[j] = mergedList[j+1];
						mergedList[j+1] = forNow;
					}
				}
			}//end of bubble sort
			
			//checks for two index's and sets to one of them if one of them is repeated.
			for(int i = 0; i < mergedList.length-1; i++) {
				if(mergedList[i] == mergedList[i+1]) {
					mergedList[i] = 0;
				}
			}//end of for
			
			//count++ if there is a zero
			for(int k = 0; k < mergedList.length; k++) {
				if(mergedList[k] != 0) {
					count++;
				}
			}//end of for
			
			//second bubble sort
			for(int i = 0; i < l-1; i++) {
				for(int j = 0; j < l-1; j++) {
					if(mergedList[j]<mergedList[j+1])
					{
						Integer forNow = mergedList[j];
						mergedList[j] = mergedList[j+1];
						mergedList[j+1] = forNow;
					}
				}
			}//end of bubble sort
			
			//array with fixed size
			int counter2=0;
			Integer[] temporary = new Integer[count];
			for(int p = 0; p < temporary.length; p++) {
				if(mergedList[p] != 0) {
					temporary[counter2] = mergedList[p];
					counter2++;
				}
			}//end of for
			
//			
//			mergedList = new Integer[count];
//			for(int i = 0; i < count; i++) {
//			    mergedList[i] = temporary[i];
//			}
			
			return temporary;
		}

		public static void main(String[] args) {
			Employee John = new Employee();
			Employee Mike = new Employee();
			Integer[] test = {1,2,3};
			Integer[] test2 = {2,3,4};
			John.setAdvisors(test);
			Mike.setAdvisors(test2);
			

			System.out.println(Arrays.toString(Employee.getAllAdvisors(Mike, John)));
			System.out.println("value of count: " + count);
			//System.out.println(Arrays.toS);
			

		}
		
		
	}
