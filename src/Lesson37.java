import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;

public class Lesson37 extends JFrame {

    static JLabel lFirstName, lLastName, lBirthDate;

    static JTextField tfFirstName, tfLastName, tfBirthDate;

    static java.util.Date dateBirthDate, sqlBirthDate;

    static Object[][] databaseResult;

    static Object[] columns = {"First Name", "Last Name", "Birth Date"};

    static DefaultTableModel dTableModel = new DefaultTableModel(databaseResult, columns) {
        @Override
        public Class getColumnClass(int column) {
            Class returnValue;
            if((column >= 0) && (column < getColumnCount())) {
                returnValue = getValueAt(0, column).getClass();
                
            }
            else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    static JTable table = new JTable(dTableModel);

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_db", "root", "ZqfR9962+");
            Statement sqlState = conn.createStatement();
            String selectStuff = "SELECT first_name, last_name, birth_date FROM customer";
            ResultSet rows = sqlState.executeQuery(selectStuff);

            while(rows.next()) {
                System.out.println(rows.getString(1) +"\t"+rows.getString(2)+"\t"+rows.getDate(3));
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }



        frame.setSize(1200, 400);
        frame.setVisible(true);

    } // END OF MAIN

} // END OF LESSON37
