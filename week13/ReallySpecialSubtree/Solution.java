import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pp = find(p);
        int pq = find(q);
        if (pp != pq) {
            if (size[pp] > size[pq]) {
                int tmp = pp;
                pp = pq;
                pq = tmp;
            }
            parent[pq] = pp;
            size[pp] += size[pq];
        }
    }

    public int find(int p) {
        if (p == parent[p]) return p;
        return parent[p] = find(parent[p]);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < gFrom.size(); i++) {
            edges.add(new int[]{gFrom.get(i), gTo.get(i), gWeight.get(i)});
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        UnionFind uf = new UnionFind(gNodes);

        int totalWeight = 0;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if (!uf.isConnected(from, to)) {
                uf.union(from, to);
                totalWeight += weight;
            }
        }

        return totalWeight;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            gFrom.add(Integer.parseInt(gFromToWeight[0]));
            gTo.add(Integer.parseInt(gFromToWeight[1]));
            gWeight.add(Integer.parseInt(gFromToWeight[2]));
        }

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
