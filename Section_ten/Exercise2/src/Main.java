import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        out.print("Digite o padrão da matriz: ");
        int standard = sc.nextInt();

        int[][] matriz = new int[standard][standard];

        for(int i = 0; i < standard; i++) {
            out.println("\nDigite os valores da linha " + (i + 1));

            for(int j = 0; j < standard; j++) {
                out.printf("   - Digite o valor da %dº coluna: ", (j + 1));
                matriz[i][j] = sc.nextInt();
            }
        }

        out.print("\nDiagonal principal: ");
        for(int i = 0; i < standard; i++) {
            out.print("[" + matriz[i][i] + "] ");
        }

        int negativeCounter = 0;

        out.print("\nNúemros negativos: ");
        for(int i = 0; i < standard; i++) {
            for(int j = 0; j < standard; j++) {
                if(matriz[i][j] < 0) {
                    negativeCounter++;
                }
            }
        }
        out.println(negativeCounter);
    }
}