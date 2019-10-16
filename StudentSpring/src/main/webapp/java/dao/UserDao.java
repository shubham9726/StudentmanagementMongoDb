package dao;

import model.Student;
import mysqlconfig.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao() {
        try {
            connection = Database.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkUser(Student student) {
        try {

            PreparedStatement ps = connection.prepareStatement("select rollNo from student1 where name = ?");
            ps.setString(1, student.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                updateUser(student);
            } else {
                addUser(student);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }

    public void addUser(Student student) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("insert into student1 values(?, ?, ?, ?)");

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(2, Integer.valueOf(student.getRollNo()));
        preparedStatement.setString(3, student.getAddress());
        preparedStatement.setString(4, student.getMobile());
        preparedStatement.executeUpdate();

    }

    public void deleteUser(Integer rollNo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student1 where rollNo=?");
            preparedStatement.setInt(1, Integer.parseInt(String.valueOf(rollNo)));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Student student) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("update student1 set name=? , address=?, mobile=?" + "where rollNo=?");

        preparedStatement.setString(1, student.getName());
        preparedStatement.setInt(4, student.getRollNo());
        preparedStatement.setString(2, student.getAddress());
        preparedStatement.setString(3, student.getMobile());
        preparedStatement.executeUpdate();
    }

    public List<Student> getAllUsers() {
        List<Student> student1 = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student1");
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setRollNo(rs.getInt("rollNo"));
                student.setAddress(rs.getString("address"));
                student.setMobile(rs.getString("mobile"));
                student1.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student1;
    }

    public Student getUserById(Integer rollNo) {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student1 where rollno=?");
            preparedStatement.setInt(1, rollNo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                student.setName(rs.getString("name"));
                student.setRollNo(rs.getInt("rollNo"));
                student.setAddress(rs.getString("address"));
                student.setMobile(rs.getString("mobile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
