package shapes;

public class Shape {
    private double area = 0;
    private double perimeter = 0;

    protected double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    protected double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void displayArea() {
        System.out.println("The area of this shape can't be found.");
    }

    public void displayPerimeter() {
        System.out.println("The perimeter of this shape can't be found.");
    }
}
