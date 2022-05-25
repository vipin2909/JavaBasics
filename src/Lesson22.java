import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;

public class Lesson22 extends JFrame{

    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeprator;
    JRadioButton addNums, subtractNums, MultNums, diviNums;
    JSlider howManyTimes;
    double number1, number2, totalCal;
    public static void main(String[] args) {
        new Lesson22();
    }

    Lesson22() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Third frame");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Calculate");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);
        label1 = new JLabel("Number 1");
        thePanel.add(label1);

        textField1 = new JTextField("",5);
        thePanel.add(textField1);
        label2 = new JLabel("Number 2");
        thePanel.add(label2);

        textField2 = new JTextField("",5);
        thePanel.add(textField2);
        dollarSign = new JCheckBox("Dollars");
        commaSeprator = new JCheckBox("Commas");

        thePanel.add(dollarSign);
        // true means check by default
        thePanel.add(commaSeprator, true);

        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract");
        MultNums = new JRadioButton("Multiply");
        diviNums = new JRadioButton("Divide");

        ButtonGroup operation = new ButtonGroup();
        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(MultNums);
        operation.add(diviNums);

        JPanel operPanel = new JPanel();
        Border operBorder = BorderFactory.createTitledBorder("Operation");

        operPanel.setBorder(operBorder);
        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(MultNums);
        operPanel.add(diviNums);

        addNums.setSelected(true);

        thePanel.add(operPanel);
        label3 = new JLabel("Perform how many times");
        thePanel.add(label3);
        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
//        ListenForSlider lForSlider = new ListenForSlider();
//        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);
        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();






    }
    private class ListenForButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                try {
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());

                }
                catch(NumberFormatException exce){
                    JOptionPane.showMessageDialog(Lesson22.this, "Please enter the right info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if(addNums.isSelected()) {
                    totalCal = addNumber(number1, number2, howManyTimes.getValue());
                }
                else if(subtractNums.isSelected()) {
                    totalCal = subtractNumber(number1, number2, howManyTimes.getValue());
                }
                else if(MultNums.isSelected()) {
                    totalCal = multiplyNumbers(number1, number2, howManyTimes.getValue());

                }
                else {
                    totalCal = divideNumbers(number1, number2, howManyTimes.getValue());
                }
                if(dollarSign.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(Lesson22.this, numberFormat.format(totalCal), "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(commaSeprator.isSelected()) {
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Lesson22.this, numberFormat.format(totalCal), "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
                else {
                    JOptionPane.showMessageDialog(Lesson22.this,totalCal, "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }

    }
    private class ListenForSlider implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == howManyTimes) {
                label3.setText("Perform how many times? "+howManyTimes.getValue());
            }

        }
    }

    public static double addNumber(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1+number2);
            i+=1;
        }
        return total;
    }
    public static double subtractNumber(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1-number2);
            i+=1;
        }
        return total;
    }
    public static double multiplyNumbers(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1+number2);
            i+=1;
        }
        return total;
    }
    public static double divideNumbers(double number1, double number2, int howManyTimes) {
        double total = 0;
        int i = 1;
        while(i <= howManyTimes) {
            total += (number1+number2);
            i+=1;
        }
        return total;
    }

}
