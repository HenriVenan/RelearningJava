package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Enter the number of shapes: ");
        int numberOfShapes = sc.nextInt();
        List<Shape> shapeList = new ArrayList<>();

        for (int i = 0; i < numberOfShapes; i++) {
            out.printf("\nShape #%d data: ", (i + 1));
            out.print("Rectangle or Circle (c/r): ");
            char shapeType = sc.next().charAt(0);

            if((shapeType != 'c') && (shapeType != 'r')) {
                out.println("Enter with valid number!");
                System.exit(0);
            }

            out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next().toUpperCase());

            if(shapeType == 'r') {
                out.print("Width: ");
                double width = sc.nextDouble();

                out.print("Height: ");
                double height = sc.nextDouble();

                shapeList.add(new Rectangle(
                        color,
                        width,
                        height
                ));
            }

            else {
                out.print("Radius: ");
                double radius = sc.nextDouble();

                shapeList.add(new Circle(
                        color,
                        radius
                ));
            }
        }

        out.println("\nShape Areas");
        for (Shape shape : shapeList) {
            if (shape instanceof Circle) {
                out.println("Circle Area: " + String.format("%.2f", shape.getArea()));
            }

            if (shape instanceof Rectangle) {
                out.println("Rectangle Area: " + shape.getArea());
            }
        }
    }
}