

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class expensetracker extends JFrame implements ActionListener {
    private JTextField expenseField;
    private JTextField typeField;
    private JComboBox<String> monthComboBox;
    private double[] monthlyExpense;
    private JTextField tReportField;

    public expensetracker() {
        setTitle("Monthly expense Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Initialize monthly expense array
        monthlyExpense = new double[12];

        // expense Label and Text Field
        JLabel expenseLabel = new JLabel("Enter Expense:");
        expenseField = new JTextField(10);
        
        JLabel typeLabel = new JLabel("Enter Expense Type:");
        typeField = new JTextField(10);
        
        JLabel tReportLabel = new JLabel("Enter Expense Type:");
        typeField = new JTextField(10);

        // Month Label and Combo Box
        JLabel monthLabel = new JLabel("Select Month:");
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);

        // Add Button
        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(this);

        // Report Button
        JButton reportButton = new JButton("Generate Report");
        reportButton.addActionListener(this);
     // specific Report Button
        JButton specificReportButton = new JButton("Generate Type Report");
        reportButton.addActionListener(this);

        // Layout
        setLayout(new FlowLayout());
        add(expenseLabel);
        add(expenseField);
        add(typeLabel);
        add(typeField);
        add(monthLabel);
        add(monthComboBox);
        add(addButton);
        add(reportButton);
        add(specificReportButton);

        pack();
        setVisible(true);
        setSize(750,110);
        setLocationRelativeTo(null);
    }
        //action for both buttons
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add expense")) {
            String expenseText = expenseField.getText();
            double expense = Double.parseDouble(expenseText);
            int monthIndex = monthComboBox.getSelectedIndex();
            monthlyExpense[monthIndex] = expense;
            JOptionPane.showMessageDialog(this, "expense added successfully!","", JOptionPane.PLAIN_MESSAGE);
            expenseField.setText("");
        } else if (e.getActionCommand().equals("Generate Report")) {
            generateReport();
        }
    }

    private void generateReport() {
        double totalexpense = 0.0;
        StringBuilder report = new StringBuilder();
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        report.append("Monthly expense Report:\n");
        report.append("----------------------\n");
        for (int i = 0; i < 12; i++) {
            report.append(months[i]).append(": $").append(monthlyExpense[i]).append("\n");
            totalexpense += monthlyExpense[i];
        }
        report.append("----------------------\n");
        report.append("Total expense: $").append(totalexpense).append("\n");

        JOptionPane.showMessageDialog(this, report.toString(),"", JOptionPane.PLAIN_MESSAGE);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new expensetracker();
            }
        });
    }
}




/*
private void generateSpecificReport() {
double totalexpense = 0.0;
StringBuilder report = new StringBuilder();
String[] months = {"January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"};

report.append("Monthly expense Report:\n");
report.append("----------------------\n");
for (int i = 0; i < 12; i++) {
    report.append(months[i]).append(": $").append(monthlyExpense[i]).append("\n");
    totalexpense += monthlyExpense[i];
}
report.append("----------------------\n");
report.append("Total expense: $").append(totalexpense).append("\n");

JOptionPane.showMessageDialog(this, report.toString(),"", JOptionPane.PLAIN_MESSAGE);
}
*/