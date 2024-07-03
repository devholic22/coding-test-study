package suggestion_bonus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

// 24.07.03 (수)
public class problem_09_압축 {

    // 1 <= msg.length() <= 1000 -> O(N^2)도 가능
    /*
    의사 코드
        1. msg를 받는다.
        2. 단어 - 색인 번호로 관리할 HashMap을 선언하고, 저장한다.
        3. 색인 번호가 계속 늘어날 수 있기에 변수를 분리해둔다.
        4. msg를 큐 화 해둔다. 앞에서부터 제거하기 때문이다.
        5. 최대한 사전에 있는 가장 긴 문자열을 찾아서 반환하는 함수를 만든다. 동시에 그만큼 큐에서 문자열을 제거해야 한다.
        6. 5번에서 찾은 문자열이 사전에 있으면 결과 변수에 그 문자열에 해당하는 색인을 넣는다.
        7. 큐가 남아있을 때에는 5번에서 찾은 문자열 + 큐의 맨 앞 문자열과 색인을 Map에 넣는다.
    시간 복잡도: O(N) (findMax에서 큐 문자열을 제거시켜주기 때문)
    */
    public int[] solution(String msg) {
        // Map 초기화
        HashMap<String, Integer> map = new HashMap<>();
        int index = 1; // 색인 변수
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), index);
            index++;
        }

        ArrayList<Integer> list = new ArrayList<>(); // 결괏값 변수

        // 문자열 msg를 큐에 보관
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] tokens = msg.split("");
        for (String t : tokens) {
            queue.addLast(t);
        }

        // 문자열이 남아있을 때 계속 진행
        while (!queue.isEmpty()) {
            // 최대로 존재하는 문자열 가져옴, 그만큼 큐에서 제거
            String value = findMax(queue, map);
            // 문자열에 해당되는 색인을 list에 넣기
            if (map.containsKey(value)) {
                list.add(map.get(value));
            }
            // 큐가 비어있지 않다면 다음 문자열을 더한 문자열을 map에 등록
            if (!queue.isEmpty()) {
                map.put(value + queue.peekFirst(), index);
                index++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public String findMax(ArrayDeque<String> queue, HashMap<String, Integer> map) {
        StringBuilder builder = new StringBuilder("");
        builder.append(queue.pollFirst()); // 첫 번째 문자열이 기본으로 들어감
        // 다음 문자열을 더했을 때도 map에 포함되어 있다면 실제로 꺼내서 문자열을 더함
        while (!queue.isEmpty() && map.containsKey(builder.toString() + queue.peekFirst())) {
            builder.append(queue.pollFirst());
        }
        return builder.toString();
    }
}
