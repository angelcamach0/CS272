import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFileOp {
	public static String[] pplUnder30 = new String[302];
	public static int i = 0;
	
	public static void main(String[] args) {
	 read("core_dataset.csv");
	 /* for (int o = 0; o < i; o++) {
		 System.out.println(pplUnder30[o]);
		 } */
	 write("young_employee.csv");
	}
	
	public static void read(String fname){
		String line;
		try {
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            
            while((line = bufferedReader.readLine()) != null) {
            	String[] rowLine = new String[23];
            	rowLine = line.split(",");
            	int age = Integer.parseInt(rowLine[6]);
            	if (age <= 30) {
            		pplUnder30[i]= new String(line);
            		i++;
            	}
            }  
            bufferedReader.close();     
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
		System.out.println("Finish reading pairs from file "+ fname);
	}
	
	public static void write(String fname){
		try {
			File file = new File(fname);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Employee Name, Employee Number, State, Zip, Age, Sex\n");
			for(int f = 0; f < i; f++){
				if(pplUnder30 != null) {
					bw.write(pplUnder30[f]);
					bw.write("\n");
				}
    		}
		bw.close();
		fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finish writing pairs to file "+ fname);
	}
}