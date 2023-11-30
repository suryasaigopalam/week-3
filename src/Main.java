import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Expense {
    private final String description;
    private final double amount;
    private final String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
}
public class Main {
    private final List<Expense> expenses;
    public Main() {
        expenses = new ArrayList<>();
    }
    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
    }
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("Expense List:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Amount: $" + expense.getAmount());
            System.out.println("Category: " + expense.getCategory());
            System.out.println("-------------");
        }
    }
    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
    public double getTotalExpensesByCategory(String category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Main tracker = new Main();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. View Total Expenses by Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Amount in rupees: R");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    tracker.addExpense(description, amount, category);
                    System.out.println("Expense added successfully!");
                }
                case 2 -> tracker.viewExpenses();
                case 3 -> System.out.println("Total Expenses: $" + tracker.getTotalExpenses());
                case 4 -> {
                    System.out.print("Enter Category: ");
                    String categoryFilter = scanner.nextLine();
                    System.out.println("Total Expenses in " + categoryFilter + ": $" + tracker.getTotalExpensesByCategory(categoryFilter));
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}