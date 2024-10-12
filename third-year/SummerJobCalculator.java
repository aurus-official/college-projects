import java.util.Scanner;

public class SummerJobCalculator {
    public static void main(String[] args) {
        final float TAX_PERCENTAGE = 0.14f;
        final float CLOTH_ACC_PERCENTAGE = 0.10f;
        final float SCHOOL_SUP_PERCENTAGE = 0.01f;
        final float SAVINGS_BONDS_PERCENTAGE = 0.25f;
        final float EXTRA_BONDS_RATE = 0.50f;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter pay rate for an hour : ");
        float payRate = scanner.nextFloat();

        System.out.print("Enter number of hours worked : ");
        float hoursWorked = scanner.nextFloat();

        scanner.close();

        float grossIncome = payRate * hoursWorked;
        float netIncome = grossIncome - (grossIncome * TAX_PERCENTAGE);
        float spentOnClothAndAcc = netIncome * CLOTH_ACC_PERCENTAGE;
        float spentOnSchoolSupp = netIncome * SCHOOL_SUP_PERCENTAGE;
        float spentOnSavingBonds = netIncome * SAVINGS_BONDS_PERCENTAGE;
        float extraBonds = spentOnSavingBonds * EXTRA_BONDS_RATE;

        System.out.println(String.format("A : Gross Income : %.2f, Net Income : %.2f", grossIncome, netIncome));
        System.out.println(
                String.format("B : The money you spend on clothes and accessories : %.2f", spentOnClothAndAcc));
        System.out.println(String.format("C : The money you spend on school supplies : %.2f", spentOnSchoolSupp));
        System.out.println(String.format("D : The money you spend to buy savings bonds : %.2f", spentOnSavingBonds));
        System.out.println(String.format(
                "E : The money your parents spend to buy additional savings bonds for you : %.2f", extraBonds));
    }
}
