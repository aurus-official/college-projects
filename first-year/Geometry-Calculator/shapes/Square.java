package shapes;

import shapes.Shape;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
        this.computeArea();
        this.computePerimeter();
    }

    private void computeArea() {
        double area = Math.pow(this.side, 2);
        super.setArea(area);
    }

    private void computePerimeter() {
        double perimeter = this.side * 4;
        super.setPerimeter(perimeter);
    }

    @Override
    public void displayArea() {
        System.out.println(String.format("Squ(A) : %.2f", super.getArea()));
    }

    @Override
    public void displayPerimeter() {
        System.out.println(String.format("Squ(P) : %.2f", super.getPerimeter()));
    }
}
