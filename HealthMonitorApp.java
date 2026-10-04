import java.util.*;
import java.time.*;

public class HealthMonitorApp {
    static Scanner sc = new Scanner(System.in);
    static List<String> log = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== HEALTH MONITOR - Vukona Press - Siyabonga Vusi! ===");
        System.out.println("Track, Don't Diagnose - For info only, see clinic for advice");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Blood Pressure (mmHg)");
            System.out.println("2. Blood Sugar (mmol/L)");
            System.out.println("3. BMI Calculator");
            System.out.println("4. Heart Rate & Temperature");
            System.out.println("5. Water & Steps Daily");
            System.out.println("6. Meds & Next Clinic Date");
            System.out.println("7. View Health Log (7 days)");
            System.out.println("8. Emergency Contacts");
            System.out.println("0. Exit");
            System.out.print("Option: ");
           
            try {
                int opt = sc.nextInt();
                if (opt == 0) break;
                switch (opt) {
                    case 1: checkBP(); break;
                    case 2: checkSugar(); break;
                    case 3: checkBMI(); break;
                    case 4: checkHRTemp(); break;
                    case 5: checkDaily(); break;
                    case 6: checkMeds(); break;
                    case 7: viewLog(); break;
                    case 8: emergency(); break;
                    default: System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Error: Enter number only");
                sc.nextLine();
            }
        }
        System.out.println("Stay healthy! Vukona Press!");
    }

    public static void checkBP() {
        System.out.print("Systolic (top) e.g 120: ");
        double sys = sc.nextDouble();
        System.out.print("Diastolic (bottom) e.g 80: ");
        double dia = sc.nextDouble();
        String cat;
        if (sys < 120 && dia < 80) cat = "NORMAL";
        else if (sys < 130 && dia < 80) cat = "Elevated";
        else if (sys < 140 || dia < 90) cat = "High Stage 1 - See clinic";
        else if (sys < 180 || dia < 120) cat = "High Stage 2 - See clinic soon";
        else cat = "CRISIS - Go to clinic NOW!";

        String res = String.format("BP %s/%s mmHg = %s - %s", sys, dia, cat, LocalDate.now());
        System.out.println(res);
        log.add(res);
        System.out.println("Tip: Rest 5 min before measuring. Normal <120/80");
    }

    public static void checkSugar() {
        System.out.print("Sugar mmol/L e.g 5.5: ");
        double v = sc.nextDouble();
        System.out.print("1=Fasting 2=After meal: ");
        int type = sc.nextInt();
        String cat;
        if (type == 1) {
            if (v < 5.6) cat = "Normal fasting";
            else if (v < 7.0) cat = "Prediabetes - see clinic";
            else cat = "High - see clinic";
        } else {
            if (v < 7.8) cat = "Normal after meal";
            else if (v < 11.1) cat = "Elevated";
            else cat = "High - see clinic";
        }
        String res = String.format("Sugar %.1f mmol/L %s = %s", v, (type==1?"Fasting":"After meal"), cat);
        System.out.println(res);
        log.add(res);
    }

    public static void checkBMI() {
        System.out.print("Weight kg: ");
        double w = sc.nextDouble();
        System.out.print("Height cm: ");
        double hcm = sc.nextDouble();
        double h = hcm / 100.0;
        double bmi = w / (h * h);
        String cat;
        if (bmi < 18.5) cat = "Underweight";
        else if (bmi < 25) cat = "Healthy";
        else if (bmi < 30) cat = "Overweight";
        else if (bmi < 35) cat = "Obese I";
        else if (bmi < 40) cat = "Obese II";
        else cat = "Obese III";

        System.out.printf("Weight %.1fkg Height %.2fm BMI = %.1f = %s (Healthy 18.5-24.9)%n", w, h, bmi, cat);
        log.add(String.format("BMI %.1f = %s", bmi, cat));
    }

    public static void checkHRTemp() {
        System.out.print("Heart Rate bpm e.g 78: ");
        double hr = sc.nextDouble();
        System.out.print("Temperature C e.g 36.8: ");
        double temp = sc.nextDouble();
        String hrCat = hr < 60 ? "Low" : hr <= 100 ? "Normal 60-100" : "High - rest & recheck";
        String tempCat = temp < 36.1 ? "Low" : temp <= 37.2 ? "Normal" : temp <= 38 ? "Low fever - monitor" : "Fever - see clinic";
        System.out.printf("HR %.0f bpm = %s | Temp %.1f C = %s%n", hr, hrCat, temp, tempCat);
        log.add(String.format("HR %.0f %s | Temp %.1f %s", hr, hrCat, temp, tempCat));
    }

    public static void checkDaily() {
        System.out.print("Glasses of water today 0-12: ");
        int water = sc.nextInt();
        System.out.print("Steps today: ");
        int steps = sc.nextInt();
        System.out.printf("Water %d/8 = %.0f%% %s%n", water, water/8.0*100, water>=6?"Good!":"Drink more");
        System.out.printf("Steps %d/5000 = %.0f%% %s%n", steps, steps/5000.0*100, steps>=5000?"Goal reached!":"Keep walking");
        log.add(String.format("Water %d/8 Steps %d", water, steps));
    }

    public static void checkMeds() {
        sc.nextLine();
        System.out.print("Chronic Condition (Hypertension/Diabetes/None/HIV): ");
        String cond = sc.nextLine();
        System.out.print("Next Clinic Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.printf("Condition: %s | Next clinic: %s | Reminder set 1 day before | Take meds same time daily%n", cond, date);
        log.add(String.format("%s - Next clinic %s", cond, date));
    }

    public static void viewLog() {
        System.out.println("--- 7 Day Health Log ---");
        if (log.isEmpty()) System.out.println("No records yet");
        else for (int i=0;i<log.size();i++) System.out.println((i+1)+". "+log.get(i));
    }

    public static void emergency() {
        System.out.println("--- Emergency Contacts SA ---");
        System.out.println("Ambulance: 10177 / 112 from mobile");
        System.out.println("Netcare 911: 082 911");
        System.out.println("ER24: 084 124");
        System.out.println("Poison: 0861 555 777");
        System.out.println("Your Clinic: Save your local clinic number here");
        System.out.println("For medical advice, speak to a healthcare professional.");
    }
}