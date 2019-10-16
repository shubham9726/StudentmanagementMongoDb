package action;

import operations.Operations;

import java.util.Scanner;

public class studentmanagement {
    public static void main(String[] args) {
        char choice;
        Scanner scan = new Scanner(System.in);
        Operations data = new Operations();
        do {
            System.out.println("**********************************************");
            System.out.println("-----entity.Student Management System-----");
            System.out.println("press 1 : For Insert entity.Student Record");
            System.out.println("press 2 : For Display entity.Student Record");
            System.out.println("press 3 : For Delete entity.Student Record");
            System.out.println("press 4 : For Exit program");
            System.out.println("press 5 : For Update entity.Student Record");
            System.out.println("Enter Your Choice :");
            choice = scan.next().charAt(0);
            switch (choice) {
                case '1':
                    /**
                     * @purpose : To perform Add Student data.
                     */
                    data.addStudent();
                    break;
                case '2':
                    /**
                     * @purpose : To perform display student data.
                     */
                    data.display();

                    break;
                case '3':
                    /**
                     * @purpose : To perform delete student data.
                     */
                    data.delete();
                    break;
                case '4':
                    System.out.println("Exit program");
                    /**
                     * @purpose : To perform exit operations.
                     */
                    System.exit(0);
                    break;
                case '5':
                    /**
                     * @purpose : To perform update student record.
                     */
                    data.update();
                    break;

            }
        }
        while (choice != 6);
    }
}