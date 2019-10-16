package java.io.dz;
import java.lang.*;
import java.util.*;
import java.util.Scanner;
public class StudentData1 {
    static List<StudentData> StudentData=new ArrayList<StudentData> ();
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        boolean y = true;
        do {
            System.out.println("Enter 1 to add_Student in list\n 2  to view_Student\n 3 to update_Student\n 4 to Delete_Student\n 5 to Exit");
            System.out.println("Enter your choice");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    add_Student();
                    break;
                case 2:
                    view_Student();
                    break;
                case 3:
                    update_Student();
                    break;
                case 4:
                    delete_Student();
                    break;
                case 5:
                    toexit();
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
            System.out.println("want to process more y/n");
            String x = s.next();
            char ch = x.charAt(0);
            if (ch == 'n')
                y = false;
        }
        while (y != false);
    }
    static public void add_Student()
    {
        Scanner s = new Scanner(System.in);
        ArrayList<StudentData> StudentData1=new ArrayList<StudentData>()
        boolean y = true;
        do {
            //System.out.println("Enter Student details");
            String name = s.nextLine();
            System.out.println("Enter name" + name);
            int rol = s.nextInt();
            System.out.println("Enter Roll No" + rol);
            int Age = s.nextInt();
            System.out.println("Enter Age" + Age);
            StudentData1.add(new StudentData(name,rol,Age));
            System.out.println("want to process more y/n");
        }
        while (y != false);
    }
    static public void view_Student()
    {
        Scanner s = new Scanner(System.in);
        boolean y = true;
        do {

        }
        while (y != false);
    }
    static public void update_Student()
    {
        Scanner s = new Scanner(System.in);
        boolean y = true;
        do {

        }
        while (y != false);
    }
    static public void delete_Student()
    {
        Scanner s = new Scanner(System.in);
        boolean y = true;
        do {

        }
        while (y != false);
    }
    static public void toexit()
    {
        System.exit(6);
    }
}