import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

// Extends JFrame so it can create frames
public class Lesson21 extends JFrame {
    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;
    public static void main(String[] args) {
        new Lesson21();
    }
    public Lesson21() {
        this.setSize(400, 400);
//        this.setLocationRelativeTo(null);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPosition = (dim.width/2)-(this.getWidth()/2);
        int yPosition = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPosition, yPosition);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My second frame");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Click Here");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        textField1 = new JTextField("", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        thePanel.add(textField1);
        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollBar1);
        this.add(thePanel);
        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);
        this.setVisible(true);
        ListenForMouse lForMouse = new ListenForMouse();
        thePanel.addMouseListener(lForMouse);

    }

    // Implemenet Listeners

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                buttonClicked++;
                textArea1.append("Button clicked " + buttonClicked + " times\n");
//                e.getSource().toString();
            }
        }
    }

    private class ListenForKeys implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    private class ListenForWindow implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
           textArea1.append("Window created");
        }

        @Override
        public void windowClosing(WindowEvent e) {

        }
        // this.disposed();
        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {
           textArea1.append("Window is minimized");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window is Active");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window is not active");
        }
    }
    private class ListenForMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse panel position: " + e.getX() + " " + e.getY() + '\n');

            textArea1.append("Mouse screen position: " + e.getXOnScreen() + " " + e.getYOnScreen() + '\n');

            textArea1.append("Mouse button: " + e.getButton() + '\n');
            textArea1.append("Mouse clickes "+e.getClickCount()+"\n");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
