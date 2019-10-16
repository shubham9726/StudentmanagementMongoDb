import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> someStudent = new ArrayList<Student>();
        char quit = 'Y';
        int id;
        String name;
        float cgpa;
        while(quit == 'Y'){
            System.out.print("\n ID: ");
            id=scan.nextInt();

            System.out.print("\n Name: ");
            name=scan.next();

            System.out.print("\n CGPA: ");
            cgpa=scan.nextFloat();

            someStudent.add (new Student(id, name, cgpa));
            System.out.print(" Enter Another Record? (Y/N)");
            String word = scan.next();
            word = word.toUpperCase();
            quit= word.charAt(0);
            //scan.close();
        }
        for(Student student:someStudent){
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.cgpa);
        }
        System.out.print("Select student by ID: ";
        int pickID = scan.nextInt();
        boolean found = false;
        for(Student s : someStudent){
            if(s.id == pickID && !found){
                update(s);
                found = true;
            }
        }
        if(!found){
            System.out.println("No student with that ID.");
        }
        public void update(Student s){
            boolean edit = true;
            while(edit){
                System.out.println(String.format("Select operation:\n1. Change name\n2. Change ID\n3. Change CGPA\n4. Delete\n5. Done"));
                int opt = scan.nextInt();
                switch(opt){
                    case 1:
                        String newName = scan.next();
                        s.setName(newName);
                        break;
                    case 2:
                        int newID = scan.nextInt();
                        s.setID(newID);
                        break;
                    case 3:
                        float newCGPA = scan.nextFloat();
                        s.setCGPA(newCGPA);
                        break;
                    case 4:
                        for(int i=0;i<someStudent.length();i++){
                            if(someStudent.get(i)==s){
                                someStudent.remove(i);
                            }
                        }
                        break;
                    case 5:
                        edit = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
class Student {

    public int id;
    public String name;
    public float cgpa;

    public Student(int id,String name,float cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
        public void setID(int id)
        {this.id=id;}
        public void setName(String name)
        {this.name=name;}
        public void setCGPA(float cgpa)
        {this.cgpa=cgpa;}

    }
}
