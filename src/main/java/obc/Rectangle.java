package obc;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        if(height<=0 || width<=0) throw new RuntimeException("height and width must be positive");
        this.height = height;
        this.width = width;

    }

    public int getArea() {
        return this.height * this.width;
    }

    public int getPerimeter() {
        return this.height * 2 + this.width * 2;
    }
}
