import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
// this allows very specifically render out information inside of each cell of table
import javax.swing.table.DefaultTableCellRenderer;
// allows to define exactly methods inside jtables and so forth
import javax.swing.table.DefaultTableModel;
// use to define changes to columns and so on
import javax.swing.table.TableColumn;

public class Lesson36 {
    // this code is good example for model view controller
    static Object[][] databaseInfo;
    static Object[] columns = {"first_name", "last_name", "email", "company", "street", "city"};

    // a resultset contains a table of data filled with all the results of a query OR it has all your query results
    static ResultSet rows;
    // it contains the information of data returned from the query
    static ResultSetMetaData metaData;
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columns) {
        // if we don't override this method getColumnClass it treats every column or entity as a string from the database
        @Override
        public Class getColumnClass (int column) {
            Class returnValue;
            if((column >= 0) && (column < getColumnCount())) {
                // getClass() return the value for myColumn
                returnValue = getValueAt(0, column).getClass();
            }
            else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Connection conn = null;
        try {
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_db", "root", "ZqfR9962+");
             Statement sqlState = conn.createStatement();
             String selectStuff = "select * from customer where state = 'HR'";
             rows = sqlState.executeQuery(selectStuff);
             Object[] tempRow;
             while(rows.next()) {
                 tempRow = new Object[] {rows.getString(1), rows.getString(2), rows.getString(3), rows.getString(4), rows.getString(5), rows.getString(6)};
                 dTableModel.addRow(tempRow);
             }

        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        JTable table = new JTable(dTableModel);
        table.setRowHeight(table.getRowHeight()+10);
        table.setFont(new Font("Serif", Font.PLAIN, 20));
        table.setAutoCreateRowSorter(true);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(100);

        TableColumn col2 = table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(190);

        TableColumn tc = table.getColumn("first_name");
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        tc = table.getColumn("email");
        centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}

class CenterTableCellRenderer extends DefaultTableCellRenderer {
    public CenterTableCellRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }
}