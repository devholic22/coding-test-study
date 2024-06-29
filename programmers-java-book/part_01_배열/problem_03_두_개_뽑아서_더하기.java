package part_01_배열;

import java.util.ArrayList;
import java.util.Arrays;

// 24.06.15 (토)
// 24.06.29 (토) review
public class problem_03_두_개_뽑아서_더하기 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/68644
    // numbers 길이: 2 ~ 100 -> 즉, O(N^2)도 충분합니다.
    // 각 수의 값: 0 ~ 100
    /*
    의사 코드
        1. 정수 배열을 받는다.
        2. 만들 수 있는 수들을 저장할 ArrayList를 선언한다. 가변적으로 여러 수가 들어올 수 있기 때문에 이용
        3. 배열에서 특정 인덱스 값을 받는다.
        4. 그 인덱스 값보다 큰 인덱스 값을 가진 배열 원소를 더한다.
        5. 해당 더해진 값을 ArrayList에 담는다.
        6. ArrayList에서 중복 값을 제거한다.
        7. ArrayList를 int[]로 변환한다.
        8. 변환된 정수 배열을 오름차순 정렬한다.
        9. 배열을 반환한다.
    */
    public int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>(); // 가변적으로 받을 수 있도록 선언합니다.
        // 간단한 방법으로 이중 for문을 돌립니다. 시간 복잡도는 O(N^2logN^2)이 됩니다. (N^2의 데이터를 정렬하기 때문)
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                answer.add(sum);
            }
        }
        int[] result = answer.stream()
                .mapToInt(x -> x)
                .distinct() // distinct()를 이용하여 문제 예시처럼 중복된 값을 제거하도록 합니다.
             // .sorted() .sorted()를 이용할 수도 있습니다.
                .toArray();
        Arrays.sort(result); // 반환하기 전 오름차순 정렬합니다.
        // 또다른 방법: HashSet으로 선언한 다음 정렬시키고 반환
        return result;
    }
}
