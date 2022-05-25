import javax.management.ListenerNotFoundException;
import javax.swing.*;
import java.awt.event.*;

public class Lesson25 extends JFrame{

    JButton button1;
    String infoOnComponent;
    JList favMovies, favColors;
    DefaultListModel defListModel = new DefaultListModel();

    public static void main(String[] args) {
        new Lesson25();
    }

    public Lesson25() {

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My fifth Frame");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);
        String[] movies = {"Matrix", "Minority Report", "Big"};
        favMovies = new JList(movies);
        favMovies.setFixedCellHeight(30);
        favMovies.setFixedCellWidth(150);
        favMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
