package week10.CheckBST;

import java.util.Scanner;

public class Solution {
    private static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean checkBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
    
        if (node.data <= min || node.data >= max) {
            return false;
        }
    
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        Node cur;
        if (data <= root.data) {
            cur = insert(root.left, data);
            root.left = cur;
        } else {
            cur = insert(root.right, data);
            root.right = cur;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean check = new Solution().checkBST(root);
        System.out.println(check ? "Yes" : "No");
    }
}
