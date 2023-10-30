package week10.HeightOfBinaryTree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
	

    public static void maxHeight(Node root, int level,int[] mxLevel) {
        if(root == null) return;
        mxLevel[0] = Math.max(mxLevel[0], level);
        
        maxHeight(root.left, level+1,mxLevel);
        maxHeight(root.right, level+1,mxLevel);
    }
    public static int height(Node root) {
          // Write your code here.
          int []mxLevel = new int[1];
          mxLevel[0] = 0;
          maxHeight(root, 0, mxLevel);
          return mxLevel[0];
    }
  
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}

