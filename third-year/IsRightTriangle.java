import java.util.Scanner;

public class IsRightTriangle {
    public static void main(String[] args) {
        int inputtedNums[] = new int[3];
        int squaredNums[] = new int[3];
        int maxNumIndex = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st number : ");
        inputtedNums[0] = scanner.nextInt();
        squaredNums[0] = inputtedNums[0] * inputtedNums[0];
        sum += squaredNums[0];

        System.out.print("Enter 2nd number : ");
        inputtedNums[1] = scanner.nextInt();
        squaredNums[1] = inputtedNums[1] * inputtedNums[1];
        sum += squaredNums[1];

        System.out.print("Enter 3rd number : ");
        inputtedNums[2] = scanner.nextInt();
        squaredNums[2] = inputtedNums[2] * inputtedNums[2];
        sum += squaredNums[2];

        scanner.close();

        maxNumIndex = inputtedNums[0] > inputtedNums[1] ? 0 : 1;
        maxNumIndex = inputtedNums[maxNumIndex] > inputtedNums[2] ? maxNumIndex : 2;

        if (sum - squaredNums[maxNumIndex] == squaredNums[maxNumIndex]) {
            System.out.println("RIGHT");
            return;
        }

        System.out.println("NOT RIGHT");
    }
}
