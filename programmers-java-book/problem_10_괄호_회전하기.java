import java.util.ArrayDeque;
import java.util.HashMap;

// 24.06.18 (화)
// 24.06.30 (일) review
public class problem_10_괄호_회전하기 {

    // s 길이: 1 ~ 1,000 -> O(N^2)도 가능
    // 각 값: () [] {}
    /*
    의사 코드
        1. 문자열 s를 받는다.
        2. 문자열 s를 배열화한다.
        3. HashMap을 선언한다.
        4. HashMap에 여는 괄호와 닫는 괄호의 짝을 저장해둔다.
        5. i번만큼 움직인 문자열 함수를 정의한다.
            5-1. ArrayDeque 스택을 정의한다.
            5-2. 문자열을 전부 순차적으로 스택에 넣는다.
            5-3. i번 만큼 맨 앞에 있던 값을 뺀 뒤 맨 뒤에 넣는다.
            5-4. 스택을 문자열화 하여 반환한다.
        6. 괄호 유효성 함수를 정의한다.
            6-1. ArrayDeque 스택을 정의한다.
            6-2. 비어있을 때 닫는 괄호라면 false
            6-3. 여는 괄호라면 push
            6-4. 짝이 맞고 닫는 괄호라면 poll, 짝이 맞지 않는다면 push
            6-5. 스택이 비어있는지 반환
        7. 유효성 수를 의미하는 변수를 선언한다.
        8. 0 ~ s - 1번 회전했을 때 유효성이 몇 번 나왔는지 더한다.
        9. 해당 값을 반환한다.
    시간 복잡도: O(N^2)
    */
    public int solution(String s) {
        String[] tokens = s.split("");
        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        int count = 0;
        for (int i = 0; i < tokens.length; i++) {
            String[] test = move(i, tokens).split("");
            if (isValid(test, map)) {
                count++;
            }
        }
        return count;
    }
    // i번만큼 움직인 함수
    public String move(int n, String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String t : tokens) {
            stack.addLast(t);
        }
        for (int i = 0; i < n; i++) {
            stack.addLast(stack.pollFirst());
        }
        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.append(stack.pollFirst()); // First부터 꺼내야 의도한대로 됨
        }
        return builder.toString();
    }

    // 유효성 검사 함수
    public boolean isValid(String[] tokens, HashMap<String, String> map) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if (stack.isEmpty() && ")]}".contains(t)) {
                return false;
            }
            if ("([{".contains(t)) { // 여는 괄호면 무조건 push
                stack.addLast(t);
                continue;
            }
            // 닫는 괄호일 때는 짝이 같아야만 poll
            if (!stack.isEmpty() && stack.peekLast().equals(map.get(t))) {
                stack.pollLast();
            } else {
                stack.addLast(t);
            }
        }
        return stack.isEmpty();
    }
}
