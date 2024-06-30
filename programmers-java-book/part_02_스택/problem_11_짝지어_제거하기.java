package part_02_스택;

import java.util.ArrayDeque;

// 24.06.19 (수)
// 24.06.30 (일) review
public class problem_11_짝지어_제거하기 {

    // 문자열의 길이: 1 ~ 1,000,000 -> O(N)
    // 문자열은 모두 소문자
    /*
    의사 코드
        1. 문자열 s를 입력받고 배열화
        2. 문자열 배열을 순회하면서
            2-1. 스택이 비어있으면 push
            2-2. 스택의 마지막 값과 문자열이 같다면 poll
        3. 스택이 비어있는지 반환
    시간 복잡도: O(N)
    */
    public int solution(String s) {
        String[] tokens = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if (stack.isEmpty()) {
                stack.addLast(t);
            } else {
                if (stack.peekLast().equals(t)) {
                    stack.pollLast();
                } else {
                    stack.addLast(t);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
