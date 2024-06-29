import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 24.06.14 (금)
// 24.06.29 (토) review
public class problem_02_배열_제어하기 {

    // 정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution() 함수를 구현하세요.
    // 배열 길이: 2 ~ 1,000
    // 각 배열의 데이터 값: -100,000 ~ 100,000
    // 권장 시간 복잡도: O(NlogN)
    /*
    의사 코드
        1. 정수 배열을 받는다.
        2. 배열의 중복값을 제거한다.
        3. 배열을 내림차순 정렬한다.
        4. 중복값 제거, 내림차순 정렬된 배열을 반환한다.
     */
    public static void main(String[] args) {
        int[][] numbers = {{4, 2, 2, 1, 3, 4}, {2, 1, 1, 3, 2, 5, 4}};
        for (int[] test : numbers) {
            System.out.println("solution(test) = " + Arrays.toString(solution(test)));
        }
    }

    public static int[] solution(int[] test) {
        // 최대 O(NlogN)의 시간 복잡도를 써야 하며, 중복을 제거해야 합니다.
        // 그러므로 우선 O(N) 안에 중복을 제거할 수 있는 Set을 이용하겠습니다.
        Set<Integer> arr = new HashSet<>();
        for (int number : test) {
            arr.add(number);
        }
        // 그 다음, Set을 내림차순으로 정렬합니다.
        // 이때 내림차순으로 정렬하기 위해 Collections.reverseOrder()를 이용하겠습니다. 그런데 이것은 참조형에서만 가능합니다.
        Integer[] result = arr.stream()
                .mapToInt(x -> x)
                .boxed()
                .toArray(Integer[]::new); // 보완할 점: <스트림>을 배열로 변환할 때 <배열 클래스 타입>을 지정해야 함
        Arrays.sort(result, Collections.reverseOrder());
        // 다시 result를 문제에 맞게 int[]로 변환한 뒤 반환하겠습니다.
        int[] answer = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            answer[i] = result[i];
        }
        return answer;
        // 전체 시간 복잡도는 O(NlogN)이라 할 수 있습니다.
        // 보완할 점: int[] <-> Integer[], Set<Integer> -> Integer[] 변환 다루기

        // 더 나은 방법
        // Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new); // int[] -> Integer[], 중복 제거
        // Arrays.sort(result, Collections.reverseOrder());
        // return Arrays.stream(result).mapToInt(Integer::intValue).toArray(); // Integer[] -> int[]
    }
}
