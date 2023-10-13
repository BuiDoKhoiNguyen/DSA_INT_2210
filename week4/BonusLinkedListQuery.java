package week4;
import java.util.Scanner;

public class BonusLinkedListQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < q; k++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();

            if (d == 0) {
                // Reverse the submatrix vertically
                for (int i = x, j = u; i < j; i++, j--) {
                    for (int jj = y; jj < v; jj++) {
                        int temp = table[i][jj];
                        table[i][jj] = table[j][jj];
                        table[j][jj] = temp;
                    }
                }
            } else if (d == 1) {
                // Reverse the submatrix horizontally
                for (int j = y, jj = v; j < jj; j++, jj--) {
                    for (int ii = x; ii < u; ii++) {
                        int temp = table[ii][j];
                        table[ii][j] = table[ii][jj];
                        table[ii][jj] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
