import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;
import java.util.Date;

public class Lesson30 extends JFrame {

    JLabel nameLabel, streetLabel, stateLabel, dateLabel, ageLabel, sexLabel, optionsLabel, aboutLabel;
    JTextField nameText, streetText;
    JComboBox stateList;
    JSpinner dateSpin;
    JSlider ageSlider;
    JRadioButton maleRadio, womenRadio;
    ButtonGroup sexGroup;
    JCheckBox morningCheck, afterCheck, eveningCheck;
    JTextArea aboutYou;

    public static void main(String[] args) {
        new Lesson30();
    }

    public Lesson30() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Random Layout");

        JPanel thePanel = new JPanel();

        thePanel.setLayout(new GridBagLayout());

        nameLabel = new JLabel("Name: ");
        addComp(thePanel, nameLabel, 0, 0,  1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        nameText = new JTextField(30);
        addComp(thePanel, nameText, 0, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        streetLabel = new JLabel("Street");
        addComp(thePanel, streetLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        streetText = new JTextField(30);
        addComp(thePanel, streetText, 0, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        Box sexBox = Box.createVerticalBox();
        maleRadio = new JRadioButton("Male");
        womenRadio = new JRadioButton("Female");

        sexGroup = new ButtonGroup();
        sexGroup.add(maleRadio);
        sexGroup.add(womenRadio);

        // this type of grouping is done so that only one of them is
        // selected at a time

       // this has nothing to do with their positions
        sexBox.add(maleRadio);
        sexBox.add(womenRadio);

        sexBox.setBorder(BorderFactory.createTitledBorder("Sex"));
        addComp(thePanel, sexBox, 3, 1, 2,  1, GridBagConstraints.WEST, GridBagConstraints.NONE);


        JPanel statePanel = new JPanel();
        statePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        stateLabel = new JLabel("State");
        statePanel.add(stateLabel);
        String[] states = {"PA", "NY", "OH", "WV"};
        stateList = new JComboBox(states);
        statePanel.add(stateList);
        dateLabel = new JLabel("Appointment Date");
        statePanel.add(dateLabel);
        Date todaysDate = new Date();
        dateSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpin, "dd/MM/yy");
        dateSpin.setEditor(dateEditor);
        statePanel.add(dateSpin);
        ageLabel = new JLabel("Age: 50");
        statePanel.add(ageLabel);
        ageSlider = new JSlider(1, 99, 50);
        ListenForSlider lForSlider = new ListenForSlider();
        ageSlider.addChangeListener(lForSlider);
        statePanel.add(ageSlider);

        addComp(thePanel, streetText, 1, 2, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        JCheckBox morningCheck, afterCheck, eveningCheck;

        Box optionBox = Box.createVerticalBox();

        morningCheck = new JCheckBox("Morning");
        afterCheck = new JCheckBox("Afternoon");
        eveningCheck = new JCheckBox("Evening");

        optionBox.add(morningCheck);
        optionBox.add(afterCheck);
        optionBox.add(eveningCheck);

        optionBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));
        addComp(thePanel, optionBox, 1, 3, 2,  1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);

        aboutYou = new JTextArea(6, 40);
        aboutYou.setText("Tell us about you");

        aboutYou.setLineWrap(true);
        aboutYou.setWrapStyleWord(true);
        JScrollPane scrollBar1 = new JScrollPane(aboutYou, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addComp(thePanel, scrollBar1, 2, 3, 3,  1, GridBagConstraints.EAST, GridBagConstraints.NONE);




        this.add(thePanel);

        this.pack();
        this.setVisible(true);
    }

    private class ListenForSlider implements ChangeListener {
        // Called when spinner is changed
        @Override
        public void stateChanged(ChangeEvent e) {

            // check if source of the event was the button

            if(e.getSource() == ageSlider) {
                ageLabel.setText("Age: "+ageSlider.getValue());
            }
        }
    }

    // Needed for GridBagConstraints
    // They are used to define how the component looks on the screen
    private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = xPos;
        gridBagConstraints.gridy = yPos;
        gridBagConstraints.gridwidth = compWidth;
        gridBagConstraints.gridheight = compHeight;
        gridBagConstraints.weightx = 100;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = place;
        gridBagConstraints.fill = stretch;

        thePanel.add(comp, gridBagConstraints);

    }

}
