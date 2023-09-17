package week3;

import edu.princeton.cs.algs4.*;

public class UFClient {
    public static void main(String []args) {
        In in = new In("C:\\Users\\nguye\\IdeaProjects\\algs4\\algs4-data\\largeUF.txt");
        int N = in.readInt();
        UF uf = new UF(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }    
        }
    }   
}