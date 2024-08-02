package level1;

import java.util.HashMap;

// 24.08.02 (금)
public class 숫자_문자열과_영단어 {

    // 1 <= s.length() <= 50

    /*
    의사 코드
        1. s를 입력받는다.
        2. map을 보관해둔다. 특정 키 (문자)를 발견했을 때 특정 값 (숫자)로 변환해야 하므로 문자-숫자 형태로 저장한다.
        3. 각 키를 돌면서 문자열 s에서 키를 발견했다면 모든 키를 값으로 변경하고 저장한다.
        4. s를 반환한다.
        시간 복잡도: O(N), N은 문자열 s의 길이 의미
     */
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i <= 9; i++) {
            map.put(numbers[i], i);
        }

        for (String key : map.keySet()) {
            if (s.contains(key)) {
                // 헷갈렸던 이유: replaceAll을 한 다음 다시 할당해야 한다.
                s = s.replaceAll(key, String.valueOf(map.get(key)));
            }
        }
        return Integer.parseInt(s);
    }
}
