import java.util.Scanner;

public class ToAscendingOrder {
    public static void main(String[] args) {
        final int SPACE_CODEPOINT = 32;
        int nums[] = new int[3];
        int maxNumIndex = 0;
        String num = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input 3 integers separated with space : ");
        String inputtedData = scanner.nextLine().concat(" ");
        scanner.close();

        for (int i = 0, y = 0; i < inputtedData.length(); i++) {
            if (inputtedData.codePointAt(i) == SPACE_CODEPOINT) {
                nums[y++] = Integer.valueOf(num);
                num = "";
                continue;
            }
            num = num.concat(String.valueOf(inputtedData.charAt(i)));
        }

        maxNumIndex = nums[0] > nums[1] ? 0 : 1;
        maxNumIndex = nums[maxNumIndex] > nums[2] ? maxNumIndex : 2;

        if (maxNumIndex != 2) {
            int temp = nums[2];
            nums[2] = nums[maxNumIndex];
            nums[maxNumIndex] = temp;
        }

        maxNumIndex = nums[0] > nums[1] ? 0 : 1;
        int temp = nums[1];
        nums[1] = nums[maxNumIndex];
        nums[maxNumIndex] = temp;

        System.out.println(String.format("%d %d %d", nums[0], nums[1], nums[2]));
        System.out.println(inputtedData);
    }
}
