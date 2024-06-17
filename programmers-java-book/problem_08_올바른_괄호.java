import java.util.ArrayDeque;

// 24.06.17 (월)
public class problem_08_올바른_괄호 {

    boolean solution(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] inputs = s.split("");
        for (String input : inputs) {
            if (input.equals("(")) {
                stack.addLast(input);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pollLast();
                }
            }
        }
        return stack.isEmpty();
    }
}
