import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class TipCalculator extends JFrame implements ActionListener {
    //Formatting to only accept numbers
    //Creating the elements
    JFrame Frame = new JFrame();

    JPanel MainPanel = new JPanel();
    JButton Calc = new JButton("calculate");
    //text
    JTextField Tip = new JTextField( 20);
    JTextField People = new JTextField(20);
    JTextField Money = new JTextField(20);
    //label
    JLabel TipL = new JLabel("Tip(%)");
    JLabel PeopleL = new JLabel("People");
    JLabel MoneyL = new JLabel("Money");
    Double Final_Value = 0.0;
    JLabel Final = new JLabel("Fill in the table");
    //to calculate
    //---main
  public TipCalculator() {
      MainPanel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      //people
      gbc.gridx = 0;
      gbc.gridy = 0;
      MainPanel.add(PeopleL,gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      MainPanel.add(People, gbc);
      //money
      gbc.gridx = 0;
      gbc.gridy = 1;
      MainPanel.add(MoneyL,gbc);
     gbc.gridx = 1;
     gbc.gridy = 1;
     MainPanel.add(Money, gbc);
     //tip
     gbc.gridx = 0;
     gbc.gridy = 2;
     MainPanel.add(TipL,gbc);
     gbc.gridx = 1;
     gbc.gridy = 2;
     MainPanel.add(Tip, gbc);
     //calculate
     gbc.gridx = 0;
     gbc.gridy = 3;
     MainPanel.add(Calc,gbc);
     //Calculate button
      gbc.gridx = 0;
      gbc.gridy = 4;
      MainPanel.add(Calc,gbc);
      Calc.addActionListener(this);
      //final answer
      gbc.gridx = 0;
      gbc.gridy = 5;
      MainPanel.add(Final,gbc);
      //calulation
//      gbc.gridx = 1;
//      gbc.gridy = 0;
//      MainPanel.add(btn2, gbc);
//
//      gbc.gridwidth = 2;
//      gbc.gridx = 0;
//      gbc.gridy = 1;
//      MainPanel.add(btn3, gbc);
//
      this.add(MainPanel);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.pack();
      this.setVisible(true);
      this.setTitle("Meal splitter");
  }
    public static void main(String[] args) {
      //getting the program to run
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TipCalculator();
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
      //when the button is pressed
        try {
            double x = Double.parseDouble(Money.getText());
            double y = Double.parseDouble(People.getText());
            double z = Double.parseDouble((Tip.getText()));
            double Final_Value = ((x / z) + x) / y;
            if (People.getText().equals("") || Tip.getText().equals("") || Money.getText().equals("")) {
                //telling the program / user what they have missed
                if (People.getText().equals("")) {
                    System.out.println("No people amount has been enetered");
                    JOptionPane.showMessageDialog(null,"No people amount has been enetered");
                } else if (Tip.getText().equals("")) {
                    System.out.println("If the tip hasn't been entered");
                    JOptionPane.showMessageDialog(null,"The tip amount hasn't been entered");
                } else if (Money.getText().equals("")) {
                    System.out.println("No money has been entered");
                    JOptionPane.showMessageDialog(null,"No money has been entered");
                } else {
                    System.out.println("nothing has been entered");
                    JOptionPane.showMessageDialog(null,"nothing has been entered");
                }
            }
            //Final output
            System.out.println("Cost:" + Money.getText() + "," + "number of people:" + People.getText() + "," + "tip percentage:" + Tip.getText());
            String Format_final = String.format("%.02f", Final_Value);
            Final.setText(String.valueOf("Each person should pay:" + "£" + Format_final));
        } catch (NumberFormatException e1){
            System.out.println("User has entered a non-numerical value");
            JOptionPane.showMessageDialog(null,"the value you entered is non numerical, please enter a numerical value");
        }
        }
}
