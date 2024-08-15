package algorithm_kit.해시;

import java.util.Arrays;
import java.util.HashSet;

public class problem_03_전화번호_목록 {

    public boolean solution(String[] phone_book) {
        // 집합을 이용한다 - HashSet
        // 각 phone_book의 요소가 1 ~ 20자이기 때문에, 이를 하나씩 잘라보면서 해당 문자열을 집합이 가지고 있는지를 이용한다.
        // 그런데 "123" 같이 사이즈가 작은 게 맨 마지막에 올 수도 있기 때문에 정렬시킨다.
        Arrays.sort(phone_book);
        HashSet<String> set = new HashSet<>();
        for (String phone : phone_book) {
            int size = phone.length();
            for (int i = 0; i < size; i++) {
                // 0자부터 size - 1자 까지의 문자열을 선택한 값이 있는지
                String token = phone.substring(0, i); // {문자열}.substring(시작, 종료)를 까먹었다. 이건 O(1)을 보장한다.
                if (set.contains(token)) {
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
        // 전체 시간 복잡도: O(N * M), N은 phone_book.length, M은 phone_book의 요소의 최대 길이
    }

    // 기존 시도했던 메서드
    private String makeStr(String phone, int index) {
        StringBuilder builder = new StringBuilder("");
        String[] arr = phone.split("");
        for (int i = 0; i <= index; i++) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}
