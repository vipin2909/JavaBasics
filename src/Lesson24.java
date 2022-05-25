// lesson 23rd code is included in Lesson22 code
import javax.swing.*;
import java.awt.event.*;

public class Lesson24 extends JFrame{

    JComboBox favoriteShows;
    JButton button1;
    String infoOnComponent;
    public static void main(String[] args) {
        new Lesson24();
    }
    public Lesson24() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("this is 4th frame");
        JPanel thePanel = new JPanel();
        String[] shows = {"Breaking bad", "Life on mars", "Doctor Who"};
        favoriteShows = new JComboBox(shows);
        favoriteShows.addItem("Pushing Daises");
        thePanel.add(favoriteShows);
        button1 = new JButton("Get Answer");
        ListenForButtons listenForButtons = new ListenForButtons();
        button1.addActionListener(listenForButtons);
        thePanel.add(button1);
        this.add(thePanel);
        this.setVisible(true);
        favoriteShows.insertItemAt("Dexter", 1);
        favoriteShows.setMaximumRowCount(5);
//        favoriteShows.removeItem("Dexter");
//        favoriteShows.removeItemAt(1);
    }
    private class ListenForButtons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == button1) {
                 favoriteShows.setEditable(true);
                 infoOnComponent += "Item at 0: " + favoriteShows.getItemAt(0) + "\n";
                 infoOnComponent += "Num of shows: " + favoriteShows.getItemCount() + "\n";
                 infoOnComponent += "Selected ID: " + favoriteShows.getItemAt(0) + "\n";
                 infoOnComponent += "Selected value: " + favoriteShows.getSelectedItem() + "\n";
                 infoOnComponent += "Are editable: " + favoriteShows.isEditable() + "\n";
                 JOptionPane.showMessageDialog(Lesson24.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
                 infoOnComponent = "";

             }
        }
    }
}
