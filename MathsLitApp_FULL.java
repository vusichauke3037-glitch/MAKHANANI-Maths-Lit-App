/**
* MAKHANANI Maths Literacy App - FULL CAPS Grade 10-12
* @author Vusi Chauke
* @institution Vukona Press, Johannesburg
* @version 2.0 - 04 October 2026 - FULL CAPS EDITION
* @live PWA https://vusichauke3037-glitch.github.io/MAKHANANI-Maths-Lit-App/
* Topics: Interest, VAT, Average, Budget, Data Handling, Probability, Percentages,
*         Compound Interest, Inflation, Income Tax, Cost/Selling Price, Tariff System
*/
import java.util.Scanner;
import java.util.Arrays;

public class MathsLitApp_FULL {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  MAKHANANI Maths Lit - Vukona Press");
        System.out.println("  FULL CAPS - Johannesburg - 2026");
        System.out.println("==========================================");
        while (true) {
            System.out.println("\n=== PAPER 1 & 2 CALCULATORS ===");
            System.out.println("1. Simple Interest");
            System.out.println("2. Compound Interest");
            System.out.println("3. VAT 15%");
            System.out.println("4. Percentages");
            System.out.println("5. Class Average");
            System.out.println("6. Data Handling (Mean/Median/Mode/Range)");
            System.out.println("7. Probability");
            System.out.println("8. Budget Planner");
            System.out.println("9. Inflation Rate");
            System.out.println("10. Income Tax (SA 2026 brackets)");
            System.out.println("11. Cost Price / Selling Price / Profit");
            System.out.println("12. Tariff System (Electricity/Water)");
            System.out.println("13. Exit");
            System.out.print("Option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> calculateInterest();
                case 2 -> calculateCompoundInterest();
                case 3 -> calculateVAT();
                case 4 -> calculatePercentage();
                case 5 -> calculateAverage();
                case 6 -> calculateDataHandling();
                case 7 -> calculateProbability();
                case 8 -> calculateBudget();
                case 9 -> calculateInflation();
                case 10 -> calculateIncomeTax();
                case 11 -> calculateCostSelling();
                case 12 -> calculateTariff();
                case 13 -> { System.out.println("Vukona Press - Siyabonga Vusi!"); return; }
                default -> System.out.println("Invalid!");
            }
        }
    }

    public static void calculateInterest() {
        System.out.print("Principal R: "); double p=sc.nextDouble();
        System.out.print("Rate %: "); double r=sc.nextDouble();
        System.out.print("Years: "); double t=sc.nextDouble();
        double interest=p*r*t/100; double total=p+interest;
        System.out.printf("Interest = R%.2f%nTotal = R%.2f%n", interest, total);
    }

    public static void calculateCompoundInterest() {
        System.out.print("Principal R: "); double p=sc.nextDouble();
        System.out.print("Rate % (annual): "); double r=sc.nextDouble()/100;
        System.out.print("Years: "); double n=sc.nextDouble();
        System.out.print("Times compounded per year (1=annually): "); int m=sc.nextInt();
        double amount = p * Math.pow(1 + r/m, m*n);
        double interest = amount - p;
        System.out.printf("Amount = R%.2f%nCompound Interest = R%.2f%n", amount, interest);
    }

    public static void calculateVAT() {
        System.out.print("Price before VAT R: "); double price=sc.nextDouble();
        double vat=price*0.15; double total=price+vat;
        System.out.printf("VAT 15%% = R%.2f%nTotal = R%.2f%n", vat, total);
    }

    public static void calculatePercentage() {
        System.out.print("Value: "); double val=sc.nextDouble();
        System.out.print("Percentage % to calc: "); double perc=sc.nextDouble();
        double result=val*perc/100;
        System.out.printf("%.2f%% of %.2f = %.2f%n", perc, val, result);
        System.out.print("For %% change - Original: "); double orig=sc.nextDouble();
        System.out.print("New: "); double newVal=sc.nextDouble();
        double change= (newVal-orig)/orig*100;
        System.out.printf("%% Change = %.1f%%%n", change);
    }

    public static void calculateAverage() {
        System.out.print("Marks comma separated: "); sc.nextLine(); String input=sc.nextLine();
        String[] parts=input.split(","); double sum=0; for(String s:parts) sum+=Double.parseDouble(s.trim());
        double avg=sum/parts.length;
        System.out.printf("Average = %.1f%% (%d learners) Sum=%.0f%n", avg, parts.length, sum);
    }

    public static void calculateDataHandling() {
        System.out.print("Data comma separated: "); sc.nextLine(); String input=sc.nextLine();
        String[] parts=input.split(","); double[] data=new double[parts.length];
        for(int i=0;i<parts.length;i++) data[i]=Double.parseDouble(parts[i].trim());
        Arrays.sort(data); double sum=0; for(double d:data) sum+=d;
        double mean=sum/data.length;
        double median=data.length%2==0 ? (data[data.length/2-1]+data[data.length/2])/2 : data[data.length/2];
        double range=data[data.length-1]-data[0];
        double mode=data[0]; int maxCount=0;
        for(int i=0;i<data.length;i++){int c=0; for(double d:data) if(d==data[i]) c++; if(c>maxCount){maxCount=c; mode=data[i];}}
        System.out.printf("Sorted: %s%nMean=%.1f Median=%.0f Mode=%.0f Range=%.0f%n", Arrays.toString(data), mean, median, mode, range);
    }

    public static void calculateProbability() {
        System.out.print("Favourable: "); double fav=sc.nextDouble();
        System.out.print("Total: "); double total=sc.nextDouble();
        if(total==0){System.out.println("Total cannot be 0"); return;}
        double prob=fav/total;
        System.out.printf("P = %.3f = %.1f%%%n", prob, prob*100);
    }

    public static void calculateBudget() {
        System.out.print("Income R: "); double income=sc.nextDouble();
        System.out.print("Expenses R: "); double expenses=sc.nextDouble();
        double saved=income-expenses;
        System.out.printf("Saved = R%.2f%n", saved);
        System.out.println(saved < 0 ? "WARNING: Overspending! Budget needs attention." : "Good budgeting - Vukona Press");
    }

    public static void calculateInflation() {
        System.out.print("Current Price R: "); double price=sc.nextDouble();
        System.out.print("Inflation rate %: "); double inf=sc.nextDouble();
        System.out.print("Years: "); double years=sc.nextDouble();
        double future = price*Math.pow(1+inf/100, years);
        System.out.printf("Future Price after %.0f years = R%.2f%nIncrease = R%.2f%n", years, future, future-price);
    }

    public static void calculateIncomeTax() {
        System.out.print("Annual Taxable Income R: "); double income=sc.nextDouble();
        double tax=0;
        if(income<=237100) tax=income*0.18;
        else if(income<=370500) tax=42678+(income-237100)*0.26;
        else if(income<=512800) tax=77362+(income-370500)*0.31;
        else if(income<=673000) tax=121475+(income-512800)*0.36;
        else if(income<=857900) tax=179147+(income-673000)*0.39;
        else if(income<=1817000) tax=251258+(income-857900)*0.41;
        else tax=644489+(income-1817000)*0.45;
        double after = income-tax;
        System.out.printf("Income Tax = R%.2f%nAfter Tax = R%.2f (Monthly R%.2f)%n", tax, after, after/12);
    }
    
    public static void calculateCostSelling() {
        System.out.println("1. Profit/Loss 2. Mark-up% 3. Discount");
        System.out.print("Choose: "); int c=sc.nextInt();
        if(c==1){
            System.out.print("Cost Price R: "); double cp=sc.nextDouble();
            System.out.print("Selling Price R: "); double sp=sc.nextDouble();
            double profit=sp-cp;
            double percentage = cp != 0 ? (profit/cp)*100 : 0;
            System.out.printf("Profit/Loss = R%.2f (%.1f%%)%n", profit, percentage);
        }
        else if(c==2){
            System.out.print("Cost Price R: "); double cp=sc.nextDouble();
            System.out.print("Mark-up %: "); double mu=sc.nextDouble();
            double sp=cp*(1+mu/100);
            System.out.printf("Selling Price = R%.2f%n", sp);
        }
        else{
            System.out.print("Original Price R: "); double op=sc.nextDouble();
            System.out.print("Discount %: "); double d=sc.nextDouble();
            double sp=op*(1-d/100);
            System.out.printf("Selling Price after discount = R%.2f You save R%.2f%n", sp, op-sp);
        }
    }

    public static void calculateTariff() {
        System.out.println("Electricity Tariff Example (City Power JHB - Inclining Block)");
        System.out.print("kwh used: "); double kwh=sc.nextDouble();
        double cost=0;
        if(kwh<=350) cost=kwh*2.35;
        else if(kwh<=600) cost=350*2.35 + (kwh-350)*2.85;
        else cost=350*2.35 + 250*2.85 + (kwh-600)*3.45;
        System.out.printf("Electricity Cost = R%.2f (Avg R%.2f/kwh)%n", cost, cost/kwh);
        System.out.print("Water litres? "); double l=sc.nextDouble();
        double waterCost=0;
        if(l<=6000) waterCost=l/1000*15.0;
        else if(l<=10500) waterCost=6*15.0 + (l-6000)/1000*18.5;
        else waterCost=6*15.0 +4.5*18.5 + (l-10500)/1000*28.0;
        System.out.printf("Water Cost approx = R%.2f%n", waterCost);
    }
}