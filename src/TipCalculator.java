import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// The main class extending JFrame and implementing ActionListener for button clicks.
public class TipCalculator extends JFrame implements ActionListener {
    // Declaration of the main frame and components.
    JFrame Frame = new JFrame();
    JPanel MainPanel = new JPanel();
    JButton Calc = new JButton("calculate");
    JTextField Tip = new JTextField(20);
    JTextField People = new JTextField(20);
    JTextField Money = new JTextField(20);
    JLabel TipL = new JLabel("Tip(%)");
    JLabel PeopleL = new JLabel("People");
    JLabel MoneyL = new JLabel("Money");
    Double Final_Value = 0.0;
    JLabel Final = new JLabel("Fill in the table");

    // Constructor for the TipCalculator class.
    public TipCalculator() {
        // Setting up the layout manager for the main panel.
        this.MainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuring how components should fill up the space in the grid.
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adding the 'People' label and text field.
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.MainPanel.add(this.PeopleL, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.MainPanel.add(this.People, gbc);

        // Adding the 'Money' label and text field.
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.MainPanel.add(this.MoneyL, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.MainPanel.add(this.Money, gbc);

        // Adding the 'Tip' label and text field.
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.MainPanel.add(this.TipL, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.MainPanel.add(this.Tip, gbc);

        // Adding the 'Calculate' button.
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.MainPanel.add(this.Calc, gbc);

        // Adding the action listener to the 'Calculate' button.
        this.Calc.addActionListener(this);

        // Adding the final result label.
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Making the label span two columns.
        this.MainPanel.add(this.Final, gbc);

        // Adding the main panel to the frame and setting up frame properties.
        this.add(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Meal splitter");
    }

    // The main method to launch the application.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TipCalculator();
            }
        });
    }

    // Action event handler for the 'Calculate' button.
    public void actionPerformed(ActionEvent e) {
        // Check if any input fields are empty and display appropriate error messages.
        if (this.People.getText().equals("") || this.Tip.getText().equals("") || this.Money.getText().equals("")) {
            // ... [Error handling code here]
            return;
        }

        // Parsing input values and performing the tip calculation.
        try {
            // ... [Parsing and calculation code here]
        } catch (NumberFormatException ex) {
            // Handle case where user enters non-numerical values.
            System.out.println("User has entered a non-numerical value");
            JOptionPane.showMessageDialog((Component)null, "The value you entered is non-numerical, please enter a numerical value");
        }
    }
}

