package week4;

import java.util.Scanner;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import javafx.util.Pair;


public class FirstGreater {
    public static int[] firstGreater(int[] arr){
        Stack<Pair<Integer,Integer> > st = new Stack<>();
        Pair<Integer,Integer> p = new Pair<Integer,Integer>();

        int[] ans = new int[arr.length];
        st.push(mp.put(arr[0],0));

        for(int i=1 ; i<arr.length; i++){
            if(arr[i] > st.peek().getValue(arr[i])){
                st.push(mp());
            }
            else{
                ans[i] = 
            }

        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }    

    }
}
