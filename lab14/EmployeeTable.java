import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class EmployeeTable {

    Integer [] keys;
    Employee [] value;
    boolean [] used;
    int size; // come back to this
    int realSize;

    public EmployeeTable(){
        int x = 277;
        keys = new Integer[x];
        value = new Employee[x];
        used = new boolean[x];
        for(int i = 0; i < x; i++) {used[i] = false;}
        size = 0;
        realSize = x;
    }

    public int hashFunction(Integer key){
        return Math.abs( key % value.length);
    }

    public void put(Employee e) throws Exception {
        if (size == realSize){ throw new Exception(" Hashtable is kinda full, Dr. Cao said not to worry if this happened");} //dont worry about this yet
        // if( findIndex(e.getNo()) == -1 ){ hashFunction(e.getNo()); }
        for(int i = hashFunction(e.getNo()); i < realSize; i++){
            if(used[i] == false){
                value[i] = e;
                keys[i] = e.getNo();
                used[i] = true;
                size++;
                break;
                //System.out.println("moo");
            }
        }
    }

    public int findIndex(Integer key){
        for(int i = hashFunction(key); (i < realSize) && (used[i] == true); i++){
            if(key == keys[i]){
                return i;
                //System.out.println("moo");
            }
        }
        return -1;
    }

    public boolean remove(Integer key){
        for(int i = hashFunction(key); i < realSize; i++){
            if(keys[i] == key){
                keys[i] = 0;
                value[i] = null;
                used[i] = false;
                size--;
                break;
            }
        }
        return false;
    }



    public int search(Integer key){
        for(int i = hashFunction(key); i < realSize; i++){
            if(keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }


    /*
    This to string was directly taken from Ziad Arafat
    only for readability purposes
    */
    @Override
    public String toString() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        StringBuilder thetable = new StringBuilder();
        thetable.append("EmployeeTable{ \n value=");
        for(Employee i : value){
            if (i != null) {
                thetable.append(ANSI_GREEN).append(", ").append(i);
            } else {
                thetable.append(ANSI_RESET).append(", null");
            }
        }
        thetable.append("\n\n keys=");
        for(Integer i : keys){
            if (i != null) {
                thetable.append(ANSI_GREEN).append(", ").append(i);
            } else {
                thetable.append(ANSI_RESET).append(", null");
            }
        }
        thetable.append("\n\n used=");
        for(boolean i : used){
            if (i) {
                thetable.append(ANSI_BLUE).append(", true");
            } else {
                thetable.append(ANSI_RED).append(", false");
            }
        }
        thetable.append(ANSI_RESET);
        return thetable.toString();
    }

    public static void main(String args[]) throws Exception {
        EmployeeTable test1 = new EmployeeTable();
        EmployeeTable test2 = new EmployeeTable();
        Employee Angel = new Employee( "Angel" ,57551, 19, "NM", 88021);
        Employee Ziad = new Employee( "Ziad" ,13513, 32, "NM", 14234);
        Employee Briana = new Employee( "Briana" ,29843, 65, "NM", 1638);
        Employee Karina = new Employee( "Karina" ,13453, 21, "NM", 19372);
        Employee Lisa = new Employee( "Lisa" ,12413, 20, "NM", 18375);
        Employee Jose = new Employee( "Jose" ,13974, 13, "NM", 143247);
        Employee Luis = new Employee( "Luis" ,72346, 25, "NM", 146243);
        Employee Padilla = new Employee( "Padilla" ,28347, 20, "NM", 16345);
        Employee Cao = new Employee( "Cao" ,12347, 2, "NM", 112354);



        System.out.print("TESTING PUTS METHOD");
        System.out.println(test1);
        test1.put(Angel); test1.put(Ziad); test1.put(Briana); test1.put(Karina); test1.put(Lisa); test1.put(Jose); test1.put(Luis); test1.put(Padilla); test1.put(Cao);

        System.out.println(test1);
        System.out.println(" . . . ");

        HashMap<Integer, Employee> empMap = new HashMap<Integer, Employee>();
        String fileName = "core_dataset.csv";
        String line;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                String [] cell = line.split(",");
                Employee Testers = new Employee();
                Testers.setName(cell[1] + " " + cell[0]);
                Testers.setNo(Integer.parseInt(cell[2]));
                Testers.setState(cell[3]);
                Testers.setZipCode(Integer.parseInt(cell[4]));
                Testers.setAge(Integer.parseInt(cell[6]));
                empMap.put(Testers.getNo(), Testers);
            }
            br.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found!!");
        }
        catch(IOException o) {
            System.out.println("IO exception!");
        }

    }
}
