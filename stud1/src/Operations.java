import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Operations {
    String name;
    int rollno;
    String address;
    String mobile;
    char choice;
    int z, x, i;
    boolean y = true;

    List<Student> studentList = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public void insert() {
        Student student = new Student();

        System.out.println("-> Please Fill Student Record");

        System.out.println(" please Enter Student Name :");
        name = scan.next();
        student.setName(name);

        System.out.println(" please Enter Student RollNo :");
        rollno = scan.nextInt();
        student.setRollno(rollno);

        System.out.println(" please Enter Student Address :");
        address = scan.next();
        student.setAddress(address);

        System.out.println(" please Enter Student Mobile :");
        mobile = scan.next();
        student.setMobile(mobile);

        studentList.add(student);


    }

    public void display() {
        for (Student student : studentList) {
            System.out.println("Student Name :- " + student.getName());
            System.out.println("Student Roll Number :- " + student.getRollno());
            System.out.println("Student Address :-" + student.getAddress());
            System.out.println("Student Mobile Number :-" + student.getMobile());
            System.out.println("<<<<<<---------------->>>>>>>");
        }
    }

    public void delete() {
        Student student = new Student();
        System.out.println(" Enter RollNo For Delete Student Data");
        rollno = scan.nextInt();
        studentList.remove(rollno--);
    }

    public void update() {
        for (Student student : studentList) {
            System.out.println("Enter Roll Number for update :-");
            rollno = scan.nextInt();
            if (student.getRollno() == rollno) {
                System.out.println("<----------- Student Record----------->");
                System.out.println("Student Name :- " + student.getName());
                System.out.println("Student Roll Number :- " + student.getRollno());
                System.out.println("Student Address :-" + student.getAddress());
                System.out.println("Student Mobile Number :-" + student.getMobile());
                do {
                    boolean edit = true;
                    while (edit) {
                        System.out.println("**********************************************");
                        System.out.println("press 1 : For Update Student Name");
                        System.out.println("press 2 : For Update Student Address");
                        System.out.println("press 3 : For update Student Mobile Number");
                        System.out.println("press 4 : For update Done");
                        System.out.println("Enter Your Choice :");
                        choice = scan.next().charAt(0);
                        switch (choice) {
                            case '1':

                                System.out.println(" please Enter Student Name :");
                                name = scan.next();
                                student.setName(name);
                                studentList.iterator();
                                break;
                            case '2':
                                System.out.println(" please Enter Student Address :");
                                address = scan.next();
                                student.setAddress(address);
                                studentList.iterator();
                                break;
                            case '3':
                                System.out.println(" please Enter Student Mobile :");
                                mobile = scan.next();
                                student.setMobile(mobile);
                                studentList.iterator();
                                break;
                            case '4':
                                System.out.println("Student Name :- " + name);
                                System.out.println("Student Roll Number :- " +  rollno);
                                System.out.println("Student Address :-"+address);
                                System.out.println("Student Mobile Number :-"+ mobile);
                                System.out.println("<<<<<<---------------->>>>>>>");




                            /*    if (edit != false) {
                                    String[] ar = new String[]{};
                                    student.setName(student.getName());
                                    student.setRollno(student.getRollno());
                                    student.setAddress(student.getAddress());
                                    student.setMobile(student.getMobile());
                                    StudentManagement3.main(ar);

                                }*/
                                break;
                        }
                    }
                }

                    while (choice != 6) ;

                }
        }
    }
}