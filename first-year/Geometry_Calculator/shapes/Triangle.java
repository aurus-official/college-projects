package shapes;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        this.computeArea();
        this.computePerimeter();
    }

    private void computeArea() {
        double area = (this.base * this.height) / 2;
        super.setArea(area);
    }

    // Assume this is an equilateral triangle
    private void computePerimeter() {
        double perimeter = this.base * 3;
        super.setPerimeter(perimeter);
    }

    @Override
    public void displayArea() {
        System.out.println(String.format("Tri(A) : %.2f", super.getArea()));
    }

    @Override
    public void displayPerimeter() {
        System.out.println(String.format("Tri(P) : %.2f", super.getPerimeter()));
    }
}
