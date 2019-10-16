import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

   public class Main
   {
    public static void main(String[] args)
    {
        String name;
        String rollno;
        String address;
        String mobile;
        char choice;
       // int z,x,i;
        boolean y=true;
        Scanner scan=new Scanner(System.in);
        List lst = new ArrayList();
        do
        {
            System.out.println("**********************************************");
            System.out.println("-----Student Management System-----");
            System.out.println("press 1 : For Insert Student Record");
            System.out.println("press 2 : For Update Student Record");
            System.out.println("press 3 : For Display Student Record");
            System.out.println("press 4 : For Delete Student Record");
            System.out.println("press 5 : For Exit program");
            System.out.println("Enter Your Choice :");
            choice=scan.next().charAt(0);
            switch(choice)
            {
                case '1':
                    System.out.println("-> Please Fill Student Record");

                    System.out.println(" please Enter Student Name :");
                    name=scan.next();
                    //HashSet<String> student;
                    if(name==null)
                        System.out.println("null is not alowed");
                    else
                        lst.add(name);
                    System.out.println(" please Enter Student RollNo :");
                    rollno=scan.next();
                    if(name==null)
                        System.out.println("null is not alowed");
                    else
                        lst.add(rollno);
                    System.out.println(" please Enter Student Address :");
                    address=scan.next();
                    if(name==null)
                        System.out.println("null is not alowed");
                    else
                        lst.add(address);
                    System.out.println(" please Enter Student Mobile :");
                    mobile=scan.next();
                    if(name==null)
                        System.out.println("null is not alowed");
                    else
                        lst.add(mobile);
                    System.out.println("-> Student Record :" +lst);
                    break;
                case '3' :
                    if(lst.isEmpty())
                        System.out.println("list is empty ");
                    else
                        System.out.println("Number of student are:");
                    //for(int i=0 ; i<student.size();i++)
                    System.out.println("index  : "+ lst);
                    //System.out.println("index "+i+" : "+ student);//.get(i)+" ");
                    break;
                case '4' :System.out.println(" Enter RollNo For Delete Student Data");
                    rollno=scan.next();
                    lst.remove(rollno);
                    break;
                case '5' :System.out.println("Exit program");
                    System.exit(0);
                    break;
            }
            // while(y!=false);
        }while(choice != 6);
    }
}