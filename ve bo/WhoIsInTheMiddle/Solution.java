
import java.util.*;

public class Solution {
    private static PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Long> minHeap = new PriorityQueue<>();

    public static void addNum(long num) {
        if (maxHeap.size() != 0 && minHeap.size() != 0) {
            if (maxHeap.peek() >= num) {
                maxHeap.offer(num);
            } else if (minHeap.peek() <= num) {
                minHeap.offer(num);
            } else {
                if (maxHeap.peek() < num && num < minHeap.peek()) {
                    if (maxHeap.size() <= minHeap.size()) {
                        maxHeap.offer(num);
                    }
                    else {
                        minHeap.offer(num);
                    }
                } else {
                    if (maxHeap.peek() < num) {
                        maxHeap.offer(num);
                    } else if (minHeap.peek() > num) {
                        minHeap.offer(num);
                    }
                }
            }
        } else {
            if (maxHeap.size() != 0) {
                long maxH = maxHeap.poll();
                maxHeap.offer(maxH);

                if (num >= maxH) {
                    minHeap.offer(num);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }

            } else if (minHeap.size() != 0) {
                long minH = minHeap.poll();
                minHeap.offer(minH);

                if (num <= minH) {
                    maxHeap.offer(num);
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }
            } else {
                maxHeap.offer(num);
            }
        }
        distribute();
    }

    public static void distribute() {
        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public static void removeMedian() {
        if (maxHeap.size() > minHeap.size()) {
            maxHeap.poll();
        } else if (minHeap.size() > maxHeap.size()) {
            minHeap.poll();
        } else {
            if (maxHeap.size() != 0) {
                maxHeap.poll();
            }
        }
        distribute();
    }

    public static void printMax() {
//        LinkedList<Long> v = new LinkedList<>();
//        while (maxHeap.size() != 0) {
//            v.add(maxHeap.poll());
//        }
//        for (long x : v) {
//            maxHeap.offer(x);
//        }
//
//        System.out.printf("Max: ");
//        for (int i = v.size() - 1; i >= 0; --i) {
//            System.out.printf(v.get(i) + " ");
//        }
//        System.out.println();
    }

    public static void printMin() {
//        LinkedList<Long> v = new LinkedList<>();
//        while (minHeap.size() != 0) {
//            v.add(minHeap.poll());
//        }
//        for (long x : v) {
//            minHeap.offer(x);
//        }
//
//        System.out.printf("Min: ");
//        for (int i = 0; i < v.size(); ++i) {
//            System.out.printf(v.get(i) + " ");
//        }
//        System.out.println();
    }

    public static long findMedian() {
//        System.out.println("Size: " + maxHeap.size() + " " + minHeap.size());
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        }
        if (maxHeap.size() >= minHeap.size()) {
//            System.out.println("Size: " + maxHeap.size() + " " + minHeap.size());
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m == 0 || n == 0) return;

        for (int i = 0; i < n; i++) {
            long number = sc.nextLong();
            addNum(number);
            printMax();
            printMin();
//            System.out.println("---------");
        }

//        System.out.println("beginnn");
        while (m-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                long number = sc.nextLong();
                addNum(number);
                printMax();
                printMin();
//                System.out.println("---------");
            } else if (type == 2) {
                removeMedian();
                printMax();
                printMin();
//                System.out.println("---------");
            } else if (type == 3) {
                System.out.println(findMedian());
                printMax();
                printMin();
//                System.out.println("---------");
            }
        }
        sc.close();
    }
}