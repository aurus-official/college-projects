import shapes.*;
import java.util.Scanner;

public class Main {
    static Scanner scn = null;
    static Shape shape = null;
    static int option = 0;
    static boolean start = true;

    public static void main(String[] args) {
        scn = new Scanner(System.in);

        while (start) {
            Main.showMenu();
        }
    }

    public static void showMenu() {
        option = 0;
        System.out.println("-------------------");
        System.out.println("GEOMETRY CALCULATOR");
        System.out.println("-------------------");
        System.out.println("1) Get Area");
        System.out.println("2) Get Perimeter");
        System.out.println("3) Exit");
        System.out.println("-------------------");
        Main.getUserOption();

        switch (option) {
            case 1:
            case 2:
                shapeMenu(option == 1);
                break;
            case 3:
                System.out.println("-------------------");
                start = false;
                scn.close();
                break;
            default:
                System.out.println("-------------------");
                System.out.println("ERROR INPUT!");
        }
    }

    public static void shapeMenu(boolean getArea) {
        System.out.println("-------------------");
        System.out.println("CHOOSE THE 2D SHAPE");
        System.out.println("-------------------");
        System.out.println("1) Square");
        System.out.println("2) Rectangle");
        System.out.println("3) Circle");
        System.out.println("4) Triangle");
        System.out.println("-------------------");
        Main.getUserOption();

        switch (option) {
            case 1:
                System.out.println("-------------------");
                System.out.print("Side : ");
                double side = scn.nextDouble();
                System.out.println("-------------------");

                shape = new Square(side);

                if (getArea) {
                    shape.displayArea();
                    break;
                }

                shape.displayPerimeter();
                break;

            case 2:
                System.out.println("-------------------");
                System.out.print("Length : ");
                double length = scn.nextDouble();
                System.out.println("-------------------");
                System.out.print("Width : ");
                double width = scn.nextDouble();
                System.out.println("-------------------");

                shape = new Rectangle(length, width);

                if (getArea) {
                    shape.displayArea();
                    break;
                }

                shape.displayPerimeter();
                break;

            case 3:
                System.out.println("-------------------");
                System.out.print("Radius : ");
                double radius = scn.nextDouble();
                System.out.println("-------------------");

                shape = new Circle(radius);

                if (getArea) {
                    shape.displayArea();
                    break;
                }

                shape.displayPerimeter();
                break;

            case 4:
                System.out.println("-------------------");
                System.out.print("Base : ");
                double base = scn.nextDouble();
                System.out.println("-------------------");
                System.out.print("Height : ");
                double height = scn.nextDouble();
                System.out.println("-------------------");

                shape = new Triangle(base, height);

                if (getArea) {
                    shape.displayArea();
                    break;
                }

                shape.displayPerimeter();
                break;
        }
    }

    public static void getUserOption() {
        System.out.print("Option : ");
        option = scn.nextInt();
    }
}
