import java.util.Scanner;
public class studentmanagement {
    public static void main(String[] args)  {
        char choice;
        boolean y=true;
        Scanner scan=new Scanner(System.in);
        Operations data=new Operations();
        do
        {
            System.out.println("**********************************************");
            System.out.println("-----Student Management System-----");
            System.out.println("press 1 : For Insert Student Record");
            System.out.println("press 2 : For Display Student Record");
            System.out.println("press 3 : For Delete Student Record");
            System.out.println("press 4 : For Exit program");
            System.out.println("press 5 : For Update Student Record");
            System.out.println("Enter Your Choice :");
            choice=scan.next().charAt(0);
            switch(choice)
            {
                case '1':
                    data.insert();
                    break;
                        case '2' :
                            data.display();

                            break;
                        case '3' :
                            data.delete();
                            break;
                        case '4' :System.out.println("Exit program");
                            System.exit(0);
                            break;
                        case '5' :
                            data.update();
                            break;
            }
        }
        while(choice != 6);
    }
}