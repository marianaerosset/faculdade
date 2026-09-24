import java.util.Scanner;

public class MatrizT {
    public static void main(String[] args) {
        System.out.println("Insira o número de linhas e colunas da matriz: ");
        
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matriz = new int[m][n];

        System.out.println("Insira os elementos da matriz: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
