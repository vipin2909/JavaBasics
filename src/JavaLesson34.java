import java.sql.*;
public class JavaLesson34 {
    public static void main(String[] args) {
        Connection conn  = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/customer", "root", "ZqfR9962+");
            Statement sqlState = conn.createStatement();
            String selectStuff = "Select first_name from customer";
            ResultSet rows = sqlState.executeQuery(selectStuff);
            while(rows.next()) {
                System.out.println(rows.getString("first_name"));
            }
        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
