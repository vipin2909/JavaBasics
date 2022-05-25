//import java.awt.*;
//import java.lang.Math.*;
import java.sql.*;
// classes have public abstract or final
// have one public class per file
public class Lesson35 {

    public static void main(String[] args) {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_db", "root", "ZqfR9962+");
            Statement sqlState = conn.createStatement();
            String selectStuff = "select last_name from customer";
            ResultSet rows = sqlState.executeQuery(selectStuff);
            while(rows.next()) {
                System.out.println(rows.getString("last_name"));
            }

        }
        catch(SQLException ex) {
            System.out.println("SQLExecption: "+ex.getMessage());
            System.out.println("VendorError: "+ex.getErrorCode());
        }
//        catch(ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    } // END OF main
} // END OF Lesson35
