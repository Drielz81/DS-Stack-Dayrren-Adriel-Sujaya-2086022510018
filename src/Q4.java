

import java.util.Scanner;
import java.util.Stack;

public class Q4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String line = scanner.nextLine().trim();
        scanner.close();

        Stack<Integer> stakos = new Stack<>();
        for (String token : line.split(" ")) {
            stakos.push(Integer.parseInt(token));
        }

        int index = 1;
        while (stakos.size() >= index) {

            Stack<Integer> taken = new Stack<>();
            for (int i = 0; i < index; i++) {
                taken.push(stakos.pop());
            }

            Stack<Integer> sorted = new Stack<>();
            while (!taken.isEmpty()) {
                int current = taken.pop();
                while (!sorted.isEmpty() && sorted.peek() > current) {
                    taken.push(sorted.pop());
                }
                sorted.push(current);
            }

            Stack<Integer> reversed = new Stack<>();
            while (!sorted.isEmpty()) {
                reversed.push(sorted.pop());
            }
            while (!reversed.isEmpty()) {
                stakos.push(reversed.pop());
            }

            index++;
        }

        StringBuilder output = new StringBuilder();
        for (Object num : stakos.toArray()) {
            if (output.length() > 0) output.append(" ");
            output.append(num);
        }

        System.out.println("Output: " + output);
    }
}