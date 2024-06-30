package part_02_스택;

import java.util.ArrayDeque;

// 24.06.17 (월)
// 24.06.30 (일) review
public class problem_08_올바른_괄호 {

    // 문자열 s의 길이: 1 ~ 100,000 -> O(N^2) 미만 적합
    // 문자열 s의 구성: '(', ')'
    /*
    의사 코드
        1. 문자열 s를 입력받는다.
        2. 문자열 s를 배열화한다.
        3. 스택을 선언한다.
        4. 각 문자열을 선회한다.
        5. 스택이 비어있고, 문자열이 '(' 라면 push
        6. 스택이 비어있고, 문자열이 ')' 라면 false return
        7. 스택의 마지막 값이 '(' 일때, 문자열이 '(' 라면 push
        8. 스택의 마지막 값이 '(' 일때, 문자열이 ')' 라면 poll
        9. 스택의 마지막 값이 ')' 일때, 문자열이 '(' 라면 push -> 즉 문자열이 여는 괄호면 모두 push
        10. 스택의 마지막 값이 ')' 일때, 문자열이 ')' 라면 push -> 즉 스택의 마지막 값이 ')' 라면 모두 push
        11. 스택이 비어있는지를 반환
    전체 시간 복잡도는 O(N), push & poll & isEmpty 모두 O(1)이기 때문
    */
    boolean solution(String s) {
        String[] token = s.split(""); // 문자열을 배열화 합니다.
        ArrayDeque<String> stack = new ArrayDeque<>(); // 스택을 선언합니다.
        // 문자열을 순회하면서 유효성을 검사합니다.
        for (String t : token) {
            // 여는 괄호는 무조건 더합니다.
            if (t.equals("(")) {
                stack.addLast(t);
            } else {
                // 스택이 비어있는데 닫는 괄호라면 false
                if (stack.isEmpty()) {
                    return false;
                }
                // 스택의 마지막 값이 닫는 괄호라면 push
                if (stack.peekLast().equals(")")) {
                    stack.addLast(t);
                    continue;
                }
                // 스택의 마지막 값이 여는 괄호일 경우
                if (t.equals("(")) {
                    stack.addLast(t); // 여는 괄호는 push
                } else {
                    stack.pollLast(); // 닫는 괄호를 만났으므로 false
                }
            }
        }
        // 정상적인 괄호는 스택이 비어있어야 합니다.
        return stack.isEmpty();
    }
}
