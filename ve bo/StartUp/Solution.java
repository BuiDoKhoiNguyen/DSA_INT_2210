import java.io.*;
import java.util.*;

class StartupEvent implements Comparable<StartupEvent> {
    long value;
    int position;

    public StartupEvent(long value, int position) {
        this.value = value;
        this.position = position;
    }

    @Override
    public int compareTo(StartupEvent other) {
        if (this.value == other.value) {
            return Integer.compare(this.position, other.position);
        }
        return Long.compare(this.value, other.value);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long profit = 0;
        PriorityQueue<StartupEvent> pq = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                long u = sc.nextLong();
                StartupEvent event = new StartupEvent(u, i + 1);
                pq.add(event);
                profit += event.value;
            } else if (type == 2) {
                int v = sc.nextInt();
                while (pq.size() >= v) {
                    StartupEvent temp = pq.poll();
                    profit -= temp.value;
                }
            }
        }

        int finalType = sc.nextInt();
        int v = sc.nextInt();

        List<StartupEvent> eventList = new ArrayList<>(pq);
        eventList.sort(Comparator.comparingInt(event -> event.position));

        if (eventList.size() >= v) {
            System.out.println(profit);
            for (StartupEvent event : eventList) {
                System.out.print(event.position + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
