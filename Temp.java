import java.util.*;

public class Temp {
    public static void convertToInfix(String expression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(token);
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                stack.push(token);
            } else if (token.equals(")")) {
                String operand2 = stack.pop();
                String operator = stack.pop();
                String operand1 = stack.pop();
                String infix = "( " + operand1 + " " + operator + " " + operand2 + " )";
                stack.push(infix);
            }
        }
        System.out.println(stack.size());
        while(!stack.isEmpty()) System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        String inputExpression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        convertToInfix(inputExpression);
    }
}
