package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Database;

public class UserDao {

    private Connection connection;

    public UserDao() {
        try {
            connection = Database.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkUser(User user) {
        try {

            PreparedStatement ps = connection.prepareStatement("select rollNo from student1 where name = ?");
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                updateUser(user);
            } else {
                addUser(user);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }
    public void addUser(User user)throws SQLException {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into student1 values(?, ?, ?, ?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, Integer.valueOf(user.getRollNo()));
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setString(4,user.getMobile());
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

    public void updateUser(User user) throws SQLException {

            PreparedStatement preparedStatement = connection.prepareStatement("update student1 set name=? , address=?, mobile=?" + "where rollNo=?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(4, user.getRollNo());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setString(3, user.getMobile());
            preparedStatement.executeUpdate();
        }

    public List<User> getAllUsers() {
        List<User> student1 = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student1");
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setRollNo(rs.getInt("rollNo"));
                user.setAddress(rs.getString("address"));
                user.setMobile(rs.getString("mobile"));
                student1.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student1;
    }

    public User getUserById(Integer rollNo) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student1 where rollno=?");
            preparedStatement.setInt(1, rollNo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setRollNo(rs.getInt("rollNo"));
                user.setAddress(rs.getString("address"));
                user.setMobile(rs.getString("mobile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}