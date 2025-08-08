package application;

import entities.Circle;
import entities.Rectangle;
import services.interfaces.Shape;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        List<Circle> myCircles = new ArrayList<>();

        myShapes.add(new Rectangle(3, 2));
        myShapes.add(new Circle(2));

        out.println("Total area (Shapes): " + String.format("%.2f", totalArea(myShapes)));

        myCircles.add(new Circle(3));
        myCircles.add(new Circle(4));

        out.println("Total area (Circles):  " + String.format("%.2f", totalArea(myCircles)));
    }

    // Tipo coringa extendido aceita as subclasses de Shape
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0;

        for (Shape shape : list) {
            sum += shape.area();
        }

        return sum;
    }
}