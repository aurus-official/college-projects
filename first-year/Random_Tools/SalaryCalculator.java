import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("SALARY CALCULATOR");
        System.out.println("-----------------------");
        System.out.print("Enter time rendered -> ");
        int timeRendered = scn.nextInt();
        System.out.println("\nTIME UNITS");
        System.out.println("1) SECONDS");
        System.out.println("2) MINUTES");
        System.out.println("3) HOURS");
        System.out.println("-----------------------");
        System.out.print("Time unit number -> ");
        int selectedOption = scn.nextInt();
        System.out.print("Enter rate -> ");
        float inputtedRate = scn.nextFloat();
        scn.close();
        float salary= calculate(timeRendered, inputtedRate, selectedOption);
        System.out.println(String.format("The salary is %.2f.", salary));
    }

    public static float calculate(int timeRendered, float rate, int timeUnit) {
        switch(timeUnit) {
            case 1:
                timeRendered /= 3600;
                break;
            case 2:
                timeRendered /= 60;
                break;
            case 3:
                break;
            default:
                throw new Error("Wrong Time Unit!");
        }
        
        float fullSalary = timeRendered * rate;
        float taxDedecution = fullSalary * 0.10f;
        return fullSalary - taxDedecution;
    }
}
