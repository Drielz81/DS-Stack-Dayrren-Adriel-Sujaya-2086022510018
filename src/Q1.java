

import java.util.Stack;

public class Q1 {
    public static void main(String[] args) {
        String stack1 = "{[()]}";
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        int stlen = stack1.length();
        boolean stlengenap = (stlen % 2 == 0) ? true : false;
        boolean seimbang = true;
        String string3 = stack1
                .replace("(", ")").replace("[", "]").replace("{", "}");
        if (stlengenap) {
            for (int i = 0; i < stlen / 2; i++) {
                char karakterstring = string3.charAt(i);
                stack2.push(karakterstring);
            }
            for (int i = stlen - 1; i >= stlen / 2; i--) {
                char karakterstr = string3.charAt(i);
                stack4.push(karakterstr);
            }
            while (!stack2.empty() && !stack4.empty())
                if (stack2.pop() != stack4.pop()) {
                    seimbang = false;
                    break;
                }
            System.out.println(seimbang);

        } else {
            System.out.println(seimbang);
        }
    }

}
