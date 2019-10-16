import java.sql.*;

public class MysqlConfig {
   public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            PreparedStatement st=con.prepareStatement("query");
        }catch(SQLException se){
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
   }
}