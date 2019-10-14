package obc;

public class Rectangle {
    private final int base;
    private final int height;

    public Rectangle(int base, int height) {

        this.base = base;
        this.height = height;
    }

    public int calculateArea() {
        return this.base * this.height;
    }

    public int calculatePerimeter() {
        return this.base * 2 + this.height * 2;
    }
}
