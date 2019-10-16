import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class studentmanagement {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String name, mobile,rollno, address, s;

    public void insert() throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("studentmanagement.txt", true)));

        boolean addMore = false;

        do {
            System.out.println("Enter Student Name");
            name = bufferedReader.readLine();

            System.out.println("Enter Student Roll Number");
            /*rollno = Integer.parseInt(bufferedReader.readLine());*/
            rollno = bufferedReader.readLine();

            System.out.println("Enter Student Address");
            address = bufferedReader.readLine();

            System.out.println("Enter Student Mobile Number");
            mobile = bufferedReader.readLine();

            //printWriter.println("<<<<<<<<------------>>>>>>>>>>");
            printWriter.print("Name :-"+ name);
            printWriter.print(", Rollno :-"+ rollno);
            printWriter.print(", Address :-"+ address);
            printWriter.println(", Mobile :-"+ mobile);
            //printWriter.println("<<<<<<<---------------->>>>>>>>");
            System.out.print("\nRecords added successfully !\nDo you want to add more records ? (y/n) : ");
            s = bufferedReader.readLine();
            if (s.equalsIgnoreCase("y")) {
                addMore = true;
                System.out.println();
            } else
                addMore = false;
        }
        while (addMore);
        printWriter.close();
        showMenu();
    }

    public void display() throws IOException {
        try {
            // Open the file
            BufferedReader file = new BufferedReader(new
                    FileReader("studentmanagement.txt"));
            String name;
            int i = 1;
            // Read records from the file
            while ((name = file.readLine()) != null) {
                System.out.println("S.No. : " + (i++));
                System.out.println("-------------");
                System.out.println( name);
               /* System.out.println( file.readLine());
                System.out.println( file.readLine());
                System.out.println( file.readLine());*/
                //System.out.println("<<<<<<<<<-------------------->>>>>>>>>");
                System.out.println();
            }
            file.close();
           showMenu();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR : File not Found !!!");
        }
    }
     /*public void update() throws IOException{
        File tempFile=new File("tempFile.txt");
        PrintWriter fileWriter=new PrintWriter(new FileWriter(tempFile));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("")) {
                String strname = line.substring(line.lastIndexOf(" "), line.length());
                if (strname != null || !strname.trim().isEmpty()) {
                    //int replenishedSalary = Integer.parseInt(strCurrentSalary.trim()) + replenish;
                   // System.out.println("replenishedSalary : " + replenishedSalary);
                    //line = line.substring(0,line.lastIndexOf(" ")) + replenishedSalary;
                }
        }
    }*/
    public void delete() throws IOException {

        Scanner scan = new Scanner(new File("studentmanagement.txt"));
        ArrayList<String> lists = new ArrayList<>();
        //int i;
        while (scan.hasNextLine())
            lists.add(scan.nextLine());


        System.out.println("<<<<<<---------------->>>>>>>");
        System.out.println(lists);

        showMenu();

    }

    public void showMenu() throws IOException
    {
        System.out.print("Press 1 : Insert Student Record \nPress 2 : Display Student Records\nPress 3 : Delete Student Records\nPress 4 : Exit\n\nYour Choice : ");
        int choice = Integer.parseInt(bufferedReader.readLine());
        switch(choice) {
            case 1:
                insert();
                break;
            case 2:
                display();
                break;
            case 3:
                delete();
                break;
            case 4:
                System.exit(1);
                break;
            default:
                System.out.println("\nInvalid Choice !");
                break;
        }
    }
    public static void main(String[] args)throws IOException{
        studentmanagement call=new studentmanagement();
        call.showMenu() ;
    }
}