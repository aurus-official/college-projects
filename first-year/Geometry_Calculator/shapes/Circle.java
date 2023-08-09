package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.computeArea();
        this.computePerimeter();
    }

    private void computeArea() {
        double area = Math.pow(this.radius, 2) * 3.14;
        super.setArea(area);
    }

    private void computePerimeter() {
        double perimeter = 2 * 3.14 * this.radius;
        super.setPerimeter(perimeter);
    }

    @Override
    public void displayArea() {
        System.out.println(String.format("Cir(A) : %.2f", super.getArea()));
    }

    @Override
    public void displayPerimeter() {
        System.out.println(String.format("Cir(P) : %.2f", super.getPerimeter()));
    }
}
