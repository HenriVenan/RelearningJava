package application;

import javax.lang.model.type.NullType;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Enter quantity of lines: ");
        int lines = sc.nextInt();

        out.print("Enter quantity of columns: ");
        int columns = sc.nextInt();

        int[][] matriz = new int[lines][columns];

        for (int i = 0; i < lines; i++) {
            out.printf("\nEnter %d# line data: \n", (i + 1));
            for(int j = 0; j < columns; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        out.print("\nEnter value the amount you wanna: ");
        int valuePoint = sc.nextInt();

        for (int i = 0; i < lines; i++) {
            for(int j = 0; j < columns; j++) {
                if(matriz[i][j] == valuePoint){
                    out.printf("  - Position: [%d, %d]: ", i, j);
                    returnPositions(matriz, i, j, lines, columns);
                }
            }
        }

        sc.close();
    }

    static void returnPositions(int[][] matriz, int i, int j, int lines, int columns) {
        if(j > 0) {
            out.printf("\n     - Left: %d", matriz[i][(j - 1)]);
        }

        if((j + 1) < columns) {
            out.printf("\n     - Right: %d", matriz[i][(j + 1)]);
        }

        if(i > 0) {
            out.printf("\n     - Up: %d", matriz[(i - 1)][j]);
        }

        if((i + 1) < lines) {
            out.printf("\n     - Down: %d \n", matriz[(i + 1)][(j)]);
        }
    }
}