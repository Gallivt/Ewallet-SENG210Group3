import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonthEstimator {
    private JFrame frame;
    private JTextField itemField;
    private JTextField priceField;
    private JLabel resultLabel;

    public MonthEstimator() {
        frame = new JFrame("Savings Estimate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel itemLabel = new JLabel("Item: ");
        itemField = new JTextField(10);
        JLabel priceLabel = new JLabel("Price: ");
        priceField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        resultLabel = new JLabel();

        frame.add(itemLabel);
        frame.add(itemField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String item = itemField.getText();
            double price = Double.parseDouble(priceField.getText());
            double monthlySavings = getSavingsAmount();
            int months = calculateMonthsToSave(price, monthlySavings);
            resultLabel.setText("It will take " + months + " months to save up for " + item + ".");
        }
    }

    public static double getSavingsAmount() {
        // Implement your logic to get the monthly savings amount
        return 100.0; // Placeholder value
    }

    public static int calculateMonthsToSave(double price, double monthlySavings) {
        double totalMonths = price / monthlySavings;
        return (int) Math.ceil(totalMonths);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MonthEstimator();
            }
        });
    }
}