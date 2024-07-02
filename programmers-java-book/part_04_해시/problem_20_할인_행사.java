package part_04_해시;

import java.util.HashMap;

// 24.06.23 (일)
// 24.07.02 (화) review
public class problem_20_할인_행사 {

    // 1 <= want의 길이 = number의 길이 <= 10
    // 1 <= number의 원소 <= 10, number 원소의 합은 10
    // 10 <= discount의 길이 <= 100,000
    /*
    의사 코드
        1. want, number, discount를 입력받는다.
        2. 결과를 반환할 변수를 선언한다.
        3. want의 각 원소와 number의 각 원소를 저장할 HashMap을 선언한다. 그리고 값을 저장한다.
        4. 0일 째 부터 discount.length - 1일 째 까지 반복문을 돌린다. 그만큼 2번 변수에 카운트가 될 것이기 때문
        5. 유효성을 판단하는 내부 함수를 작성한다.
            5-1. 10일 간 선택한 품목들을 내부 HashMap에 저장한다.
            5-2. 원본 HashMap과 비교하여 충족되었을 경우 true를 반환, 아닐 경우 false를 반환한다.
        6. 2번 변수를 반환한다.
        시간 복잡도:
    */
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        // 최대 10
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        // 최대 1,000,000 (즉, O(M * N))
        for (int i = 0; i < discount.length; i++) {
            if (isValid(i, discount, map)) {
                result++;
            }
        }
        return result;
    }
    public boolean isValid(int index, String[] discount, HashMap<String, Integer> map) {
        HashMap<String, Integer> select = new HashMap<>();
        // 최대 100,000
        for (int i = index; i < Math.min(discount.length, index + 10); i++) {
            if (select.containsKey(discount[i])) {
                select.put(discount[i], select.get(discount[i]) + 1);
            } else {
                select.put(discount[i], 1);
            }
        }
        // 최대 10
        for (String key : map.keySet()) {
            if (!select.containsKey(key) || select.get(key) < map.get(key)) {
                return false;
            }
        }
        return true;
    }
}
