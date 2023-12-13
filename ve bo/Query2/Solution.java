import java.util.Scanner;

public class MinQuery {
    static int[] a = new int[300001];
    static int[] t = new int[4 * 300001];

    public static void build(int l, int r, int id) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        t[id] = Math.min(t[2 * id], t[2 * id + 1]);
    }

    public static int getMin(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return Integer.MAX_VALUE;
        if (u <= l && r <= v) return t[id];
        int mid = (l + r) / 2;
        int left = getMin(l, mid, 2 * id, u, v);
        int right = getMin(mid + 1, r, 2 * id + 1, u, v);
        return Math.min(left, right);
    }

    public static void update(int l, int r, int id, int pos, int value) {
        if (l == r) {
            t[id] = value;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) {
            update(l, mid, 2 * id, pos, value);
        } else {
            update(mid + 1, r, 2 * id + 1, pos, value);
        }
        t[id] = Math.min(t[2 * id], t[2 * id + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        build(1, n, 1);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(getMin(1, n, 1, l, r));
            } else if (type == 2) {
                int id = sc.nextInt();
                int v = sc.nextInt();
                update(1, n, 1, id, v);
            }
        }
    }
}
