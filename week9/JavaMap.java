package week9;

import java.util.*;

public class JavaMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String,String> mp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String phoneNum = sc.nextLine();
        
            mp.put(name.toLowerCase(),phoneNum);
        }

        // String[] query = new String[n];

        for(int i = 0; i < n; i++) {
            String query = sc.nextLine();
            if(mp.get(query) != null) {
                System.out.println(query + "=" + mp.get(query));
            }
            else System.out.println("Not found");
        }
    }
}

    
