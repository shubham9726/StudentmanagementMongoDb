package com.decipherzone.studentweb.dbopeartions;

import com.decipherzone.studentweb.dbconfig.DbConfig;
import com.decipherzone.studentweb.entity.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @purpose - This class performs many operations like
 * --add sttudent detaisls
 * --remove student details
 * --update student details
 */
public class DbOperations {
    private static Logger log = Logger.getLogger(DbOperations.class);

    /**
     * @return id
     * @Purpose - This method generate the student id.
     * @implnote - First it fetech the data from database-
     * if there is any data than it add 1 with the last student id
     * and if there is not data than it starts with 1 as student id.
     */
    public int generateID() {
        int id = 0;
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean i = resultSet.last();
            if (!i) {
                id = 1;
            } else {
                id = resultSet.getInt(1) + 1;
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return id;
    }

    /**
     * @param student
     * @Purpose - This method add the details entered by the user into the database.
     */
    public void addStudent(Student student) {
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values (?,?,?);");
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        }
    }

    /**
     * @param studentid
     * @purpose - This method remove the Details of the student.
     * @implnote - This method receives student id as parameter according to which it deletes the details of student
     */

    public void removeStudent(int studentid) {
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where studentid=?");
            preparedStatement.setInt(1, studentid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    /**
     * @param studentid
     * @return true if student id is present in database.
     * @purpose -  this method check the given student id is present in the database or not
     */
    public boolean idCheck(int studentid) {
        ResultSet resultSet = null;
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where studentid=?");
            preparedStatement.setInt(1, studentid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return false;
    }

    /**
     * @return the arraylist which hold all the records of the student.
     * @purpose - This method display all the records present in the database and save these record in arraylist
     */
    public List<Student> display() {
        List<Student> arraylist = new ArrayList<Student>();
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1));
                arraylist.add(student);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return arraylist;
    }

    public List<Student> displayindividuals(int studentid) {
        List<Student> arraylist = new ArrayList<Student>();
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where studentid= ?");
            preparedStatement.setInt(1, studentid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1));
                arraylist.add(student);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return arraylist;
    }

    /**
     * @param studentage
     * @param studentname
     * @param studentid
     * @pupose - this method is used to update the details of the student.
     * @implnote - This methods receives student id, student name, student age as parameter,
     * according to the student id it updates the name and age of student in the database.
     */

    public void updateStudent(int studentage, String studentname, int studentid) {
        try {
            Connection connection = DbConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update student set studentname=? , studentage= ? where studentid= ?");
            preparedStatement.setString(1, studentname);
            preparedStatement.setInt(2, studentage);
            preparedStatement.setInt(3, studentid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        }
    }


}
