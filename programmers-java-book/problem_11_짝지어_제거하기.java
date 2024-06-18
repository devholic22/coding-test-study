import java.util.ArrayDeque;

// 24.06.19 (수)
public class problem_11_짝지어_제거하기 {

    public int solution(String s) {
        String[] tokens = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (stack.isEmpty()) {
                stack.addLast(token);
            } else {
                String last = stack.peekLast();
                if (last.equals(token)) {
                    stack.pollLast();
                } else {
                    stack.addLast(token);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
