package entities;

import entities.enums.Color;

public class Rectangle extends Shape{
    private final double  width;
    private final double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (width * height);
    }
}
