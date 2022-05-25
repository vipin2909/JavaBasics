import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class LessonTwenty extends JFrame {
    public static void main(String[] args) {
        new LessonTwenty();
    }
    public LessonTwenty() {
        this.setSize(400, 400);
//        this.setLocationRelativeTo(null);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPosition = (dim.width/2)-(this.getWidth()/2);
        int yPosition = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPosition, yPosition);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My First Frame");
        JPanel thePanel = new JPanel();
        JLabel label1 = new JLabel("Tell me something");
        label1.setText("New Text");
        label1.setToolTipText("Does'nt do anything");
        thePanel.add(label1);
        JButton button1 = new JButton("Send");
//        button1.setBorderPainted(false);
//        button1.setContentAreaFilled(false);
        button1.setText("New Button");
        button1.setToolTipText("It's a button");
        thePanel.add(button1);
        JTextField textField = new JTextField("Type Here", 15);
        textField.setColumns(10);
        textField.setText("Type again");
        textField.setToolTipText("It's a field");
        thePanel.add(textField);
        JTextArea textArea1 = new JTextArea(15,20);
        textArea1.setText("Just a whle bunch of text that is important");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        int numOfLines = textArea1.getLineCount();
        textArea1.append(" number of lines: " + numOfLines);
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollBar1);
        this.add(thePanel);
        this.setVisible(true);
        textField.requestFocus();
    }
}
