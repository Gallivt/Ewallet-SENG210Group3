import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class expenseReportByType {
    public static List<expensetracker> generateExpenseReport(List<expensetracker> incomeEntries, String selectedType) {
        List<expensetracker> report = new ArrayList<>();
        for (expensetracker entry : incomeEntries) {
            if (entry.expenseTypes().equals(selectedType)) {
                report.add(entry);
            }
        }
        return report;
    }

    public static void main(String[] args) {
        // Example usage
        List<MonthlyIncomeTracker> incomeEntries = new ArrayList<>(); // List of IncomeEntry objects
        // Populate the incomeEntries list with data
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter income type (Salary, Bonus, Investments, Other): ");
        String selectedType = scanner.nextLine();
        scanner.close();
        
        List<MonthlyIncomeTracker> report = generateExpenseReport(incomeEntries, selectedType);
        
        System.out.println("Income Report:");
        for (MonthlyIncomeTracker entry : report) {
            System.out.println(entry);
        }
    }
}