package Classes;

public class Triangle {
    private double A;
    private double B;
    private double C;

    public Triangle(double a, double b, double c) {
        A = a;
        B = b;
        C = c;
    }

    public double returnArea() {
        double p = (A + B + C) / 2;
        return Math.sqrt(p*(p - A)*(p - B)*(p - C));
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }
}
