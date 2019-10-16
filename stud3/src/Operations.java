import java.sql.*;
import java.util.Scanner;


public class Operations {
    MysqlConfig msql = new MysqlConfig();
    String name;
    int rollNo;
    String address;
    String mobile;


    Scanner scan = new Scanner(System.in);

    public void insert() {
        // student student = new student();
        System.out.println("-> Please Fill Student Record");

        System.out.println(" please Enter Student Name :");
        Scanner a = new Scanner(System.in);
        name = a.next();

        System.out.println(" please Enter Student RollNo :");
        rollNo = a.nextInt();

        System.out.println(" please Enter Student Address :");
        address = a.next();

        System.out.println(" please Enter Student Mobile :");
        mobile = a.next();
        String query = "insert into student values('" + name + "'," + rollNo + ",'" + address + "','" + mobile + "')";
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement stmt = con.createStatement();
            String sql = "insert into student values('" + name + "'," + rollNo + ",'" + address + "','" + mobile + "')";
            stmt.execute(sql);
            stmt.close();
            con.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void display() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            System.out.println(" please Enter Student RollNo :");
            Scanner a = new Scanner(System.in);
            rollNo = a.nextInt();
            PreparedStatement st = con.prepareStatement("Delete from student where rollNo=" + rollNo + ";");
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        System.out.println("-> Enter information for update Student Record");

        System.out.println(" please Enter Student RollNo :");
        Scanner a = new Scanner(System.in);
        rollNo = a.nextInt();


        System.out.println(" please Enter Student Name :");
        name = a.next();

        System.out.println(" please Enter Student Address :");
        address = a.next();

        System.out.println(" please Enter Student Mobile :");
        mobile = a.next();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            PreparedStatement st = con.prepareStatement("UPDATE student SET name='" + name + "',address='" + address + "',mobile='" + mobile + "'WHERE rollno = " + rollNo + ";");
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
