import Classes.Triangle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Triangle x, y;
        double xA, xB, xC;
        double yA, yB, yC;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter measures of triangle X: ");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();

        x = new Triangle(xA, xB, xC);

        System.out.println("\nEnter measures of triangle Y: ");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        y = new Triangle(yA, yB, yC);

        System.out.printf("\nArea X: %.2f\n", x.returnArea());
        System.out.printf("Area Y: %.2f\n", y.returnArea());

        if(x.returnArea() > y.returnArea()) {
            System.out.println("Larger area: X");
        }

        else {
            System.out.println("Larger area: Y");
        }

        sc.close();
    }
}
