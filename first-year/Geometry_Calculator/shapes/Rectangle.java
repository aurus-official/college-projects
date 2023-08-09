package shapes;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.computeArea();
        this.computePerimeter();
    }

    private void computeArea() {
        double area = this.length * this.width;
        super.setArea(area);
    }

    private void computePerimeter() {
        double perimeter = (this.length * 2) + (this.width * 2);
        super.setPerimeter(perimeter);
    }

    @Override
    public void displayArea() {
        System.out.println(String.format("Rect(A) : %.2f", super.getArea()));
    }

    @Override
    public void displayPerimeter() {
        System.out.println(String.format("Rect(P) : %.2f", super.getPerimeter()));
    }
}
