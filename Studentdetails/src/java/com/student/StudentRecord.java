package java.com.student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class StudentRecord
{
    public String Rollno;
    public String Name;
    public String Section;
    public String Address;
    static Map< String, List<StudentRecord> > m=new HashMap< String, List<StudentRecord> >();

    static List<StudentRecord> ListOfStudent=new ArrayList<StudentRecord>();
    public StudentRecord(String Rollno, String Name, String Section,String Address) {
        this.Rollno = Rollno;
        this.Name=Name;
        this.Section=Section;
        this.Address=Address;
    }
    public String getRollno()
    {
        return Rollno;
    }
    public void setRollno(String rollno)
    {
        Rollno= rollno;
    }
    public String getName()
    {
        return Name;
    }
    public void setName(String name)
    {
        Name = name;
    }
    public String getSection()
    {
        return Section;
    }
    public void setSection(String section)
    {
        Section = section;
    }
    public String getAddress()
    {
        return Address;
    }
    public void setAddress(String address)
    {
        Address = address;
    }
    public String toString()
    {
        return this.Rollno+"\t"+this.Name+"\t\t"+this.Section+"\t\t\t"+this.Address;
//{
    }
    public static void main(String[] args) throws IOException
    {	File file = new File("d://StudentRecord.txt");

        //Create the file
        try {
            if (file.createNewFile()){
                System.out.println("File is created!");
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e1)
        {

            e1.printStackTrace();
        }

        //Write Content

        try
        {

            FileReader reader =new FileReader(file);


            Scanner scn1=new Scanner(System.in);
            String Rollno;
            String Name;
            String Section;
            String Address;

            while(true)
            {

                System.out.println("**********************************************");
                System.out.println("-----Student Management System-----");
                System.out.println("press 1 : For Insert Student Record");
                System.out.println("press 2 : For Update Student Record");
                System.out.println("press 3 : For Display Student Record");
                System.out.println("press 4 : For Delete All Data Of Student Record");
                System.out.println("press 5 : For Exit program");
                System.out.println("Enter Your Choice :");
                System.out.println("To quit type -1");
                int num=scn1.nextInt();
                if(num == -1)
                {
                    break;
                }

                switch(num)
                {
                    case 1:
                    {

                        System.out.println("-> Please Fill Student Record");
                        System.out.print("\n please Enter Student Section: ");
                        Section=scn1.next();
                        System.out.print("\n please Enter Student Rollno: ");
                        Rollno=scn1.next();
                        System.out.print("\n please Enter Student Name: ");
                        Name=scn1.next();
                        System.out.print("\n please Enter Student Address: ");
                        Address=scn1.next();
                        System.out.println("Thanks for adding in the Record");

                        StudentRecord employee1=new StudentRecord(Rollno,Name,Section,Address);

                        ListOfStudent.add(employee1);
                        m.put(Section, ListOfStudent);
		/*while(keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            System.out.println("key: " + key + " value: " +         map.get(key));
        }*/

                        for(int i=0;i<ListOfStudent.size();i++)
                        {
                            FileWriter fstream = new FileWriter("d://StudentRecord.txt",true);
                            BufferedWriter writer = new BufferedWriter(fstream);
                            System.out.print("\n"+ListOfStudent.get(i)+" , "+"\n\n");
                            writer.write("Name:-" + ListOfStudent.get(i).Name+" , "+"\n\n" );
                            writer.write("RollNO:-" + ListOfStudent.get(i).Rollno+" , "+"\n\n");
                            writer.write("Section:-" + ListOfStudent.get(i).Section+" , "+"\n\n");
                            writer.write("Address:-" + ListOfStudent.get(i).Address+" , "+"\n\n");
                            writer.newLine();
                            writer.close();
                        }

                        System.out.println("Successfully Insert data in file!");


                        break;
                    }
                    case 2:
                    {
                        System.out.println("Type Section to be modified");
                        Section=scn1.next();
                        System.out.println("Modification Record");
                        System.out.print("\n please Enter Student Rollno: ");
                        Rollno=scn1.next();
                        System.out.print("\n please Enter Student Name: ");
                        Name=scn1.next();
                        System.out.print("\n please Enter Student Address: ");
                        Address=scn1.next();

                        System.out.println("Student Record Update Succesfully");
                        Set<String> s=m.keySet();
                        Iterator<String> i=s.iterator();

                        StudentRecord student=new StudentRecord(Rollno,Name,Section,Address);
                        m.get(("Rollno"));

                        ListOfStudent.add(student);
                        m.put(Section, ListOfStudent);

                        while(i.hasNext())
                        {
                            //System.out.println(i.next());
                            for(int j=0;j<ListOfStudent.size();j++)
                            {
                                FileWriter fstream = new FileWriter("d://StudentRecord.txt",true);
                                BufferedWriter writer = new BufferedWriter(fstream);
                                System.out.print("\n"+ListOfStudent.get(j)+" , "+"\n\n");
                                writer.write("Name:-" + ListOfStudent.get(j).Name+" , "+"\n\n" );
                                writer.write("RollNO:-" + ListOfStudent.get(j).Rollno+" , "+"\n\n");
                                writer.write("Section:-" + ListOfStudent.get(j).Section+" , "+"\n\n");
                                writer.write("Address:-" + ListOfStudent.get(j).Address+" , "+"\n\n");
                                writer.newLine();
                                writer.close();
                            }
                        }
                        break;
                    }
                    case 3:
                    {

                        //System.out.println("=========================================================");
                        //System.out.println("Rollno"+"\t"+"NAME"+"\t\t"+"Section"+"\t\t"+"Address");
                        System.out.println("=========================================================");
                        Set<String> s=m.keySet();
                        Iterator<String> i=s.iterator();
                        BufferedReader br = new BufferedReader(new FileReader("d://StudentRecord.txt"));
                        String line;
                        while((line = br.readLine())!=null)
                        {
                            System.out.println(line);
                        }
                        br.close();
                        break;
                    }
                    case 4 :
                    {
			
		        
			/* file = new File ("d://StudentRecord.txt");
		        if (! file.exists() )
		            {
		        boolean success = file.delete();
		        }
		     
		       file.delete();
		         
		        try{
		               // Create file 
		               FileWriter fstream = new FileWriter("d://StudentRecord.txt");
		                   BufferedWriter writer = new BufferedWriter(fstream);
		            //   out.write("Hello Java");
		               writer.close();
		               System.out.println("Successfully Delete data From file! ");
		               System.out.println(" Now File Is Blank!");
		               }
		        catch (Exception e){//Catch exception if any
		                 System.err.println("Error: " + e.getMessage());
		               }*/
		 
			
			/*BufferedReader br = null;
	        String strLine = "";
	            br = new BufferedReader( new FileReader("d://StudentRecord.txt"));
	            while( (strLine = br.readLine()) != null){
	                System.out.println(strLine);
	            }*/

                        break;
                    }
                    case 5 :
                    {

                        System.out.println("Exit program");
                        System.exit(0);
                        break;
                    }
                    default :
                        System.out.println("=============================================================");
                        System.out.print("Wrong key Pressed,please enter the correct key\n");
                        System.out.println("Try again...!!!");
                        System.out.println("=============================================================");
                        break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : Message" + e.getMessage());
            System.out.println("======================================");
            System.out.println("Now you are Signing out");
            System.out.println("Thank You,Login Again");
            System.out.println("======================================");
        }
    }
}