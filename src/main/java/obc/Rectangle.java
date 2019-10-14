package obc;

public class Rectangle extends FlatShape {

    private int width;
    private int height;

    public Rectangle(int side) {
        this.width = side;
        this.height = side;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }

    @Override
    public int perimeter() {
        return 2 * height + 2 * width;
    }

    @Override
    public int area() {
        return width * height;
    }
}
