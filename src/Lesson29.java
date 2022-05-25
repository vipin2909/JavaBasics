import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Lesson29 extends JFrame {

    JButton but1, but2, but3, but4, but5, but6, but7, but8, but9, but0,
    butPlus, butMinus, clearAll, resultButton;
    int num1 = -1, num2 = -1;
    boolean isPlusPressed = false, isMinusPressed = false;
    JTextField textResult;

    public static void main(String[] args) {
        new Lesson29();
    }

    public Lesson29() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        JPanel thePanel = new JPanel();

        thePanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 50;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        textResult = new JTextField("0", 20);
        Font font = new Font("Helvetica", Font.PLAIN, 18);
        textResult.setFont(font);



        ListenForButtons listenForButtons = new ListenForButtons();


        but1 = new JButton("1");
        but1.addActionListener(listenForButtons);
        but2 = new JButton("2");
        but2.addActionListener(listenForButtons);
        but3 = new JButton("3");
        but3.addActionListener(listenForButtons);
        but4 = new JButton("4");
        but4.addActionListener(listenForButtons);
        but5 = new JButton("5");
        but5.addActionListener(listenForButtons);
        but6 = new JButton("6");
        but6.addActionListener(listenForButtons);
        but7 = new JButton("7");
        but7.addActionListener(listenForButtons);
        but8 = new JButton("8");
        but8.addActionListener(listenForButtons);
        but9 = new JButton("9");
        but9.addActionListener(listenForButtons);
        butPlus = new JButton("+");
        butPlus.addActionListener(listenForButtons);
        but0 = new JButton("0");
        but0.addActionListener(listenForButtons);
        butMinus = new JButton("-");
        butMinus.addActionListener(listenForButtons);
        clearAll = new JButton("C");
        clearAll.addActionListener(listenForButtons);
        resultButton = new JButton("=");
        resultButton.addActionListener(listenForButtons);

        thePanel.add(clearAll, gridBagConstraints);
        gridBagConstraints.gridwidth=2;
        gridBagConstraints.gridx = 5;
        thePanel.add(resultButton, gridBagConstraints);
        gridBagConstraints.gridwidth=10;
        gridBagConstraints.gridx = 9;

        thePanel.add(textResult, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;

        thePanel.add(but1, gridBagConstraints);
        gridBagConstraints.gridx = 5;

        thePanel.add(but2, gridBagConstraints);
        gridBagConstraints.gridx = 9;

        thePanel.add(but3, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;

        thePanel.add(but4, gridBagConstraints);
        gridBagConstraints.gridx = 5;

        thePanel.add(but5, gridBagConstraints);
        gridBagConstraints.gridx = 9;

        thePanel.add(but6, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;

        thePanel.add(but7, gridBagConstraints);
        gridBagConstraints.gridx = 5;

        thePanel.add(but8, gridBagConstraints);
        gridBagConstraints.gridx = 9;

        thePanel.add(but9, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;

        thePanel.add(butPlus, gridBagConstraints);
        gridBagConstraints.gridx = 5;

        thePanel.add(but0, gridBagConstraints);
        gridBagConstraints.gridx = 9;

        thePanel.add(butMinus, gridBagConstraints);



        this.add(thePanel);
        this.setVisible(true);


    }

    private class ListenForButtons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == but1) {
                textResult.setText(textResult.getText()+but1.getText());
            }
            if(e.getSource() == but2) {
                textResult.setText(textResult.getText()+but2.getText());
            }

            if(e.getSource() == but3) {
                textResult.setText(textResult.getText()+but3.getText());
            }
            if(e.getSource() == but4) {
                textResult.setText(textResult.getText()+but4.getText());
            }
            if(e.getSource() == but5) {
                textResult.setText(textResult.getText()+but5.getText());
            }
            if(e.getSource() == but6) {
                textResult.setText(textResult.getText()+but6.getText());
            }
            if(e.getSource() == but8) {
                textResult.setText(textResult.getText()+but8.getText());
            }
            if(e.getSource() == but9) {
                textResult.setText(textResult.getText()+but9.getText());
            }
            if(e.getSource() == but7) {
                textResult.setText(textResult.getText()+but7.getText());
            }
            if(e.getSource() == but0) {
                textResult.setText(textResult.getText()+but0.getText());
            }
            if(e.getSource() == clearAll) {
                textResult.setText("");
            }
           if(e.getSource() == butPlus) {
               num1 = Integer.parseInt(textResult.getText());
               textResult.setText("");

               isPlusPressed = true;
           }
           if(e.getSource() == butMinus) {
               num1 = Integer.parseInt(textResult.getText());
               textResult.setText("");
               isMinusPressed = true;
           }
           if(e.getSource() == resultButton) {
              if(num1 != -1) {
                  if(isMinusPressed) {
                      int temp = Integer.parseInt(textResult.getText());
                          textResult.setText(Integer.toString(num1-temp));
                      num1=-1;
                      isMinusPressed=false;
                  }
                  else if(isPlusPressed) {
                      int temp = Integer.parseInt(textResult.getText());
                      textResult.setText(Integer.toString(num1+temp));
                      num1=-1;
                      isPlusPressed=false;

                  }
              }
           }

        }
    }
}
