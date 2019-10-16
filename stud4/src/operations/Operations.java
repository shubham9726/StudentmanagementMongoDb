package operations;

import dao.MongodbOperations;
import entity.Student;
import org.bson.Document;

import java.util.*;
import java.util.Scanner;

/**
 * @purpose : it performs opertaions like insert, delete , update.
 */
public class Operations {

    MongodbOperations mongodbOperations = new MongodbOperations();
    Scanner scan = new Scanner(System.in);

    /**
     * @throws InputMismatchException
     * @purpose : it add details of student.
     */
    public void addStudent() throws InputMismatchException {
        Student student = new Student();
        try {
            System.out.println(" please Enter Student Name :");
            String name = scan.next();
            student.setName(name);
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            System.out.println(" please Enter Student RollNo :");
            String rollNo = scan.next();
            student.setRollNo(rollNo);
        } catch (Exception w) {
            w.getMessage();
        }

        try {
            System.out.println(" please Enter Student Address :");
            String address = scan.next();
            student.setAddress(address);
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            System.out.println(" please Enter Student Mobile :");
            String mobile = scan.next();
            student.setMobile(mobile);
        } catch (Exception e) {
            e.getMessage();
        }
        /**
         * @purpose : insert student data into a database.
         */
        mongodbOperations.insert(student);
    }

    /**
     * @purpose : To perform display related operations.
     */
    public void display() {
        List<Document> students = mongodbOperations.getAllStudents();
        if (!students.isEmpty()) {
            for (Document student : students) {

                System.out.println("Student rollno=" + student.get("rollNo"));
                System.out.println("Student name = " + student.get("name"));
                System.out.println("Student address = " + student.get("address"));
                System.out.println("Student mobile = " + student.get("mobile"));
                System.out.println("<<<<<<<<<------------->>>>>>>>>>");
            }
        } else {
            System.out.println("No Data Found");
        }
    }

    /**
     * @purpose : To perform the delete related operations.
     */
    public void delete() {
        System.out.println(" Enter RollNo For Delete Student Data");
        String rollNo = scan.next();

        List<Student> students = mongodbOperations.getByRollNo(rollNo);
        if (!students.isEmpty()) {
            mongodbOperations.delete(rollNo);
            System.out.println("Document delete");
        } else {
            System.out.println("Please Enter valid Roll Number");
        }
    }

    /**
     * @purpose : To perform update related operations.
     */
    public void update() {
        Student student = new Student();
        String rollNo = null;
        try {
            System.out.println(" please Enter Student RollNo :");
            rollNo = scan.next();
            student.setRollNo(rollNo);
        } catch (InputMismatchException e) {
            e.getMessage();
        }

        List<Student> students = mongodbOperations.getByRollNo(rollNo);
        if (!students.isEmpty()) {
            System.out.println(" please Enter Student Name :");
            String name = scan.next();
            student.setName(name);

            System.out.println(" please Enter Student Address :");
            String address = scan.next();
            student.setAddress(address);

            System.out.println(" please Enter Student Mobile :");
            String mobile = scan.next();
            student.setMobile(mobile);

            mongodbOperations.update(student);

            System.out.println("Document update successfully...");
        } else {
            System.out.println("Please Enter valid Roll Number");
        }
    }
}