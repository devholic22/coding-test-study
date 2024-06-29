package suggestion_bonus;

import java.util.ArrayList;
import java.util.Arrays;

// 24.06.30 (일)
public class problem_03_나누어_떨어지는_숫자_배열 {

    // divisor: 자연수
    // array: 길이 1 이상인 배열, 모두 자연수
    /*
    의사 코드
        1. arr, divisor 입력
        2. ArrayList 변수 할당 - 해당되는 숫자를 담기 위함
        3. 나누어 떨어질 시 ArrayList 변수에 저장
        4. 오름차순 정렬
        5. 배열 반환 (없을 시 -1 배열 반환)
    */
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 시간 복잡도: O(N)
        for (int number : arr) {
            if (number % divisor == 0) {
                answer.add(number);
            }
        }
        if (answer.isEmpty()) {
            return new int[] {-1};
        }
        int[] result = answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(result); // 시간 복잡도: O(NlogN)
        return result;
    }
}
