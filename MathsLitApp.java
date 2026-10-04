import java.util.Scanner;

public class MathsLitApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MAKHANANI MATHS LITERACY APP ===");
        System.out.println("1. Simple Interest (Loan/Investment)");
        System.out.println("2. VAT calculation (shop)");
        System.out.println("3. Class Average");
        System.out.println("4. Budget Planner");
        System.out.print("choose: ");

        int choose = sc.nextInt();

        if(choose == 1) {
            System.out.print("Principal R: "); double p = sc.nextDouble();
            System.out.print("Rate %: "); double r = sc.nextDouble();
            System.out.print("Years: "); double t = sc.nextDouble();
            double interest = (p * r * t) / 100;
            System.out.println("Interest: R" + interest);
            System.out.println("Total: R" + (p + interest));
        }
        else if(choose == 2) {
            System.out.print("Price before VAT: R"); double price = sc.nextDouble();
            System.out.println("VAT (15%): R" + (price * 0.15));
            System.out.printf("Total to pay: R%.2f%n", price * 1.15);
        }
        else if(choose == 3) {
            System.out.print("How many learners? "); int n = sc.nextInt();
            double sum = 0;
            for(int i =1; i <= n; i++) {
                System.out.print("Mark "+i+": "); sum += sc.nextDouble();
            }
            System.out.println("Class Average: " + (sum/n));
        }
        else if(choose == 4) {
            System.out.print("Monthly Income: R"); double income = sc.nextDouble();
            System.out.print("Expenses R: "); double exp = sc.nextDouble();
            double left = income - exp;
            System.out.println("Left: R" + left);
            if(left < 0) System.out.println("WARNING: You are overspending!");
            else System.out.println("Good budgeting - you saved R" + left);
        }
        sc.close();
    }
}