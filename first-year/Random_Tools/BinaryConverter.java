import java.util.Scanner;

class BinaryConverter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("NUMBER TO BINARY CONVERTER");
        System.out.print("Enter a number to convert => ");
        int inputtedValue = scn.nextInt();
        String binaryValue = Integer.toBinaryString(inputtedValue);
        System.out.println(String.format("The binary form of %s is %s.", inputtedValue, binaryValue));
    }
}
