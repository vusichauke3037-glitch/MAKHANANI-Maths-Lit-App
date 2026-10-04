/**
* MAKHANANI Maths Literacy App - CAPS Paper 1
* @author Vusi Chauke
* @institution Vukona Press, Johannesburg
* @version 1.0 - 04 October 2026
* @live PWA https://vusichauke3037-glitch.github.io/MAKHANANI-Maths-Lit-App/
*
* Description:
* Console application to support Grade 10-12 CAPS Maths Lit
* Topics: Simple Interest, VAT 15%, Class Average, Budget Planner
* Complies with CAPS requirement: All monetary values displayed as Rxx.xx
*/
import java.util.Scanner;
import java.util.Arrays;

public class MathsLitApp {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Main menu - Entry point for the application
     */
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("  MAKHANANI Maths Lit - Vukona Press");
        System.out.println("  CAPS Paper 1 - Johannesburg");
        System.out.println("======================================");
       
        while (true) {
            System.out.println("\nChoose calculator:");
            System.out.println("1. Simple Interest");
            System.out.println("2. VAT 15%");
            System.out.println("3. Class Average");
            System.out.println("4. Budget Planner");
            System.out.println("5. Exit");
            System.out.print("Option: ");
           
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> calculateInterest();
                case 2 -> calculateVAT();
                case 3 -> calculateAverage();
                case 4 -> calculateBudget();
                case 5 -> { System.out.println("Vukona Press - Goodbye!"); return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    /**
     * Calculates Simple Interest using formula I = P*R*T/100
     * Test: P=5000,R=10,T=2 => I=R1000.00 Total=R6000.00
     */
    public static void calculateInterest() {
        System.out.print("Principal R: ");
        double p = sc.nextDouble();
        System.out.print("Rate %: ");
        double r = sc.nextDouble();
        System.out.print("Years: ");
        double t = sc.nextDouble();
       
        double interest = p * r * t / 100;
        double total = p + interest;
       
        System.out.printf("Interest = R%.2f%n", interest);
        System.out.printf("Total Amount = R%.2f%n", total);
    }

    /**
     * Calculates VAT at 15% - South African rate
     * Test: Price R200 => VAT=R30.00 Total=R230.00
     */
    public static void calculateVAT() {
        System.out.print("Price before VAT R: ");
        double price = sc.nextDouble();
       
        double vat = price * 0.15;
        double total = price + vat;
       
        System.out.printf("VAT (15%%) = R%.2f%n", vat);
        System.out.printf("Total Price = R%.2f%n", total);
    }

    /**
     * Calculates class average from comma-separated marks
     * Test: 12,43,54,46,65,45,45,76,76 => Average=51.3% (9 learners)
     * Formula: Average = Sum / n
     */
    public static void calculateAverage() {
        System.out.print("Enter marks separated by comma (e.g. 12,43,54,46,65,45,45,76,76): ");
        sc.nextLine(); // consume newline
        String input = sc.nextLine();
       
        String[] parts = input.split(",");
        double sum = 0;
        for (String s : parts) {
            sum += Double.parseDouble(s.trim());
        }
        double avg = sum / parts.length;
       
        System.out.printf("Average = %.1f%% (%d learners)%n", avg, parts.length);
        System.out.printf("Total Sum = %.0f%n", sum);
    }

    /**
     * Budget planner - Income vs Expenses
     * Test: Income R15000, Expenses R16000 => Saved=R-1000.00 WARNING
     */
    public static void calculateBudget() {
        System.out.print("Income R: ");
        double income = sc.nextDouble();
        System.out.print("Expenses R: ");
        double expenses = sc.nextDouble();
       
        double saved = income - expenses;
       
        System.out.printf("Saved = R%.2f%n", saved);
        if (saved < 0) {
            System.out.println("WARNING: Over budget!");
        } else {
            System.out.println("Good budgeting - Vukona Press");
        }
    }
}