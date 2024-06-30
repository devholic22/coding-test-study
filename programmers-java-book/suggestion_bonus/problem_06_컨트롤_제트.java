package suggestion_bonus;

import java.util.ArrayDeque;

// 24.06.30 (일)
public class problem_06_컨트롤_제트 {

    // s의 길이: 1 ~ 200
    // s의 원소: -1,000 ~ 1,000
    /*
    의사 코드
        1. 문자열 s를 입력받는다.
        2. 문자열 s를 배열화한다.
        3. 목적 값을 0으로 초기화한다.
        4. 스택을 정의한다. 근거는 바로 전에 더했던 숫자를 빼는 등의 작업이 있기 때문이다.
        5. 문자열 s의 배열을 돌면서
            5-1. 차례로 push를 하다가
            5-2. Z를 만나면 마지막 요소를 pop 한다.
        6. 정리된 스택을 순회하면서 목적 값에 더한다.
    시간 복잡도: O(N)
    */
    public int solution(String s) {
        String[] command = s.split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int value = 0;
        for (String c : command) {
            if (c.equals("Z")) {
                stack.pollLast();
            } else {
                stack.addLast(Integer.parseInt(c));
            }
        }
        while (!stack.isEmpty()) {
            value += stack.pollFirst();
        }
        return value;
    }
}
