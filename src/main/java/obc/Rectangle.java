package obc;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return 2 * width + 2 * height;
    }
}
