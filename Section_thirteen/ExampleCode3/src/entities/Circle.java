package entities;

import entities.enums.Color;

public class Circle extends Shape {
    private final double  radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (Math.PI * (radius * radius));
    }
}
