package part_04_해시;

import java.util.HashMap;

// 24.06.23 (일)
// 24.07.02 (화) review
public class problem_19_완주하지_못한_선수 {

    // 마라톤 경기 참여 선수 수: 1 ~ 100,000 -> O(N^2) 미만
    // 완주자 수: 참여 선수 수 - 1
    // 참가자 이름: 1 ~ 20개의 알파벳 소문자
    // 동명이인 가능
    /*
    의사 코드
        1. 참여 선수와 완주자를 입력받음
        2. 해시 선언 - 참여 선수를 위한 해시 맵 선언, 동명이인이 있을 수 있으므로 해시 셋보다는 해시 맵으로
        3. 참여 선수 해시 맵 저장
        4. 각 완주 선수를 돌면서 참여 선수에 해당되는 이름 발견하면 감소
        5. 참여 선수를 다시 돌면서 숫자가 남아있는 참여 선수 발견 시 해당 이름을 반환
    전체 시간 복잡도는 O(N)
    */
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> part = new HashMap<>();
        for (String p : participant) {
            if (part.containsKey(p)) {
                part.put(p, part.get(p) + 1);
            } else {
                part.put(p, 1);
            }
        }
        for (String c : completion) {
            part.put(c, part.get(c) - 1);
        }
        for (String p : part.keySet()) {
            if (part.get(p) > 0) {
                return p;
            }
        }
        return null;
    }
}
