package suggestion_bonus;

import java.util.ArrayDeque;

// 24.06.30 (일)
public class problem_05_같은_숫자는_싫어 {

    // arr 크기: 1 ~ 1,000,000 -> O(N)
    // arr 원소: 0 ~ 9
    /*
    의사 코드
        1. arr 배열 입력
        2. 스택 선언
        3. 배열을 돌면서 마지막 값과 같지 않은 경우에만 push
        4. 스택의 크기만큼의 배열을 할당
        5. 배열의 각 요소에 스택 pop
        6. 배열 반환
    시간 복잡도: O(N)
    */
    public int[] solution(int []arr) {
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int number : arr) {
            if (numbers.isEmpty()) {
                numbers.addLast(number); // 스택이 비어있다면 추가
            } else {
                // 스택이 비어있지 않다면 마지막 값과 다를 경우에만 추가
                if (numbers.peekLast() != number) {
                    numbers.addLast(number);
                }
            }
        }
        // 배열에 저장
        int[] answer = new int[numbers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.pollFirst();
        }
        return answer;
    }
}
