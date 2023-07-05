import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class incomeReportByType {
    public static List<MonthlyIncomeTracker> generateIncomeReport(List<MonthlyIncomeTracker> incomeEntries, String selectedType) {
        List<MonthlyIncomeTracker> report = new ArrayList<>();
        for (MonthlyIncomeTracker entry : incomeEntries) {
            if (entry.incomeTypes().equals(selectedType)) {
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
        System.out.print("Enter expense type: ");
        String selectedType = scanner.nextLine();
        scanner.close();
        
        List<MonthlyIncomeTracker> report = generateIncomeReport(expenseEntries, selectedType);
        
        System.out.println("Income Report:");
        for (MonthlyIncomeTracker entry : report) {
            System.out.println(entry);
        }
    }
}


