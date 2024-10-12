import java.util.LinkedHashMap;
import java.util.Scanner;

class RomanConverter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("ROMAN NUMERAL CONVERTER");
        System.out.println("-----------------------");
        System.out.print("Enter a number => ");
        int inputtedValue = scn.nextInt();
        String x = toRomanNumeral(inputtedValue, "");
        System.out.println("--------------------------");
        System.out.println(String.format("The Roman Numeral of %s is %s.", inputtedValue, x));
        scn.close();
    }

    public static String toRomanNumeral(int value, String currentRoman) {
        LinkedHashMap<Integer, String> romanTable = new LinkedHashMap<Integer, String>();
        // ArrayList<Integer> records = new ArrayList<>(Arrays.asList(1000, 900, 500,
        // 400, 100, 90, 50, 40, 10, 9, 5, 4, 1));
        romanTable.put(1000, "M");
        romanTable.put(900, "CM");
        romanTable.put(500, "D");
        romanTable.put(400, "CD");
        romanTable.put(100, "C");
        romanTable.put(90, "XC");
        romanTable.put(50, "L");
        romanTable.put(40, "XL");
        romanTable.put(10, "X");
        romanTable.put(9, "IX");
        romanTable.put(5, "V");
        romanTable.put(4, "IV");
        romanTable.put(1, "I");

        if (value == 0) {
            return currentRoman;
        }

        for (int i : romanTable.keySet()) {
            if (value >= i) {
                value -= i;
                currentRoman += romanTable.get(i);
                break;
            }
        }

        return toRomanNumeral(value, currentRoman);
    }
}
