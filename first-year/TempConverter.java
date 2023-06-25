import java.util.Scanner;

interface TempConverterInterface {
    public float toCelcius(float value, String type);
    public float toFahrenheit(float value, String type);
    public float toKelvin(float value, String type);
}

class TempConverter implements TempConverterInterface {
    public float toCelcius(float value, String type) {
        System.out.println(type);
        if (type.compareToIgnoreCase("Fahrenheit") == 0) {
            return (value - 32) * 5 / 9;
        } else if (type.compareToIgnoreCase("Kelvin") == 0) {
            return value - 273.15f;
        }

        throw new Error("Error Conversion!");
    }

    public float toFahrenheit(float value, String type) {
        if (!(type.compareToIgnoreCase("Celcius") == 0) && !(type.compareToIgnoreCase("Kelvin") == 0)) {
            throw new Error("Error Conversion!");
        }

        if (type.compareToIgnoreCase("Kelvin") == 0) {
            value = toCelcius(value, type);
        }
        return (value * 9 / 5) + 32;
    }

    public float toKelvin(float value, String type) {
        if (!(type.compareToIgnoreCase("Celcius") == 0) && !(type.compareToIgnoreCase("Fahrenheit") == 0)) {
            throw new Error("Error conversion");
        }

        if (type.compareToIgnoreCase("Fahrenheit") == 0) {
            value = toCelcius(value, type);
        }
        return value + 273.15f;
    }

    public static void main(String[] args) {
        TempConverter tc = new TempConverter();
        Scanner sc = new Scanner(System.in);
        System.out.println("TEMPERATURE CONVERTER");
        System.out.print("Enter the value => ");
        float inputGiven = sc.nextFloat();

        System.out.println("\nTYPES OF TEMPERATURES");
        System.out.println("Celcius");
        System.out.println("Fahrenheit");
        System.out.println("Kelvin");

        System.out.println("\n-----------------------------------");
        System.out.print("Enter temperature type => ");
        String defaultType = sc.next();
        System.out.print("Convert to type => ");
        String toType = sc.next();
        
        float returnedValue = 0f;
        if ((toType.compareToIgnoreCase("Celcius") == 0)) {
            returnedValue += tc.toCelcius(inputGiven, defaultType);
        } else if ((toType.compareToIgnoreCase("Fahrenheit") == 0)) {
            returnedValue += tc.toFahrenheit(inputGiven, defaultType);
        } else if ((toType.compareToIgnoreCase("Kelvin") == 0)) {
            returnedValue += tc.toKelvin(inputGiven, defaultType);
        } else {
            System.out.println("You have inputted wrong values.\n");
        }
        System.out.println(String.format("%.2f", returnedValue));

        sc.close();
    }
}
