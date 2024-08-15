package algorithm_kit.해시;

import java.util.HashMap;

// 24.08.15 (목)
public class problem_02_완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {
        // 동명이인이 있을 수 있다 -> 이름과 카운트를 관리해야 하므로 HashMap을 이용한다.
        HashMap<String, Integer> map = new HashMap<>();
        // HashMap으로 넣는다.
        for (String part : participant) {
            if (map.containsKey(part)) {
                map.put(part, map.get(part) + 1);
            } else {
                map.put(part, 1);
            }
        }
        // 완료자를 한 명씩 감소시킨다.
        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }
        // 1개 이상인 게 있다면 그 사람이 완주하지 못한 사람이다.
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        return "";
        // 전체 시간 복잡도: O(N + M) => O(N), N은 participant, M은 N - 1이기에 O(N)과 동일
    }
}
