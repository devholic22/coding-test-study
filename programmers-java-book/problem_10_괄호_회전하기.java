import java.util.ArrayDeque;
import java.util.HashMap;

// 24.06.18 (화)
public class problem_10_괄호_회전하기 {

    static HashMap<String, String> bracket;

    public int solution(String s) {
        bracket = new HashMap<>();
        bracket.put(")", "(");
        bracket.put("]", "[");
        bracket.put("}", "{");

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String created = move(i, s);
            if (isValid(created)) {
                answer++;
            }
        }

        return answer;
    }

    private String move(int time, String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = s.split("");
        StringBuilder builder = new StringBuilder("");
        // ex: "()" -> ["(", ")"]
        for (String token : tokens) {
            stack.addLast(token);
        }
        // ex: time이 1일 경우 [")", "("]
        for (int i = 0; i < time; i++) {
            stack.addLast(stack.pollFirst());
        }
        // ex: 원래 "()", time이 1이었을 경우 ")("
        while (!stack.isEmpty()) {
            builder.append(stack.pollFirst());
        }
        return builder.toString();
    }

    private boolean isValid(String s) {
        String[] brackets = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String b : brackets) {
            // stack이 비어있는데 닫히는 단어가 온다면 열린 짝이 있었어야 한다는 것이므로 false
            if (stack.isEmpty() && ")]}".contains(b)) {
                return false;
            }
            // 마지막 {, 도달한 게 }라면 삭제 조치
            if (!stack.isEmpty() && stack.peekLast().equals(bracket.get(b))) {
                stack.pollLast();
            } else { // 그게 아니면 추가함
                stack.addLast(b);
            }
        }
        return stack.isEmpty();
    }
}
