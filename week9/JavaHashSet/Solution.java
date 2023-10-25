
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String pair = sc.nextLine();
            uniquePairs.add(pair);
            System.out.println(uniquePairs.size());
        }
    }
}
