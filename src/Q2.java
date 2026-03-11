

import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        String Tokens = "1 1 + 0 - 2 *";
        String[] array_rpn = Tokens.split(" ");
        Stack<Integer> stack_rpn = new Stack<>();

        for (String token_to_stack : array_rpn){
            if (token_to_stack.equals("+") || token_to_stack.equals("-") || token_to_stack.equals("*") ||token_to_stack.equals("/")){
                int b = stack_rpn.pop();
                int a = stack_rpn.pop();
                int hasil = 0;
                switch (token_to_stack){
                    case "+": hasil = a+b; break;
                    case "-": hasil = a-b; break;
                    case "*": hasil = a*b; break;
                    case "/": hasil = (int)(a/(double)b); break;
                }
                stack_rpn.push(hasil);
            } else {
                stack_rpn.push(Integer.parseInt(token_to_stack));
            }

        }

        System.out.println(stack_rpn);
    }
    
}
