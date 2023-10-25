package week2;

import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String []args) {
        In in = new In("algs4-data/tinyUF2.txt");
        int N = in.readInt();
        int key = 0;
        UF uf = new UF(N);
        while (uf.count() > 1 && !in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            key++;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
        }

        if (uf.count() == 1) {
            System.out.println(key);
        }
        else {
            System.out.println("FAILED");
        }
    }
}
