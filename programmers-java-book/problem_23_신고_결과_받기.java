import java.util.HashMap;
import java.util.HashSet;

// 24.06.25 (화)
// 24.07.02 (화) review
public class problem_23_신고_결과_받기 {

    // 2 <= id.length <= 1,000
    // 1 <= report.length <= 200,000
    // 1 <= k <= 200
    /*
    의사 코드
        1. id_list와 report, k를 받는다.
        2. id_list 순서대로 각 메일을 받도록 result 배열을 추가하고, HashMap을 생성해서 이름-인덱스 구조로 관리되게 한다.
            2-1. HashMap을 사용해야겠다고 생각한 이유: O(N) 이내에 되어야겠다고 생각을 했고, 각 사람이 몇 개의 이메일을 받는지 차례로 증가될 수 있기 때문
        3. 이름-신고 횟수를 관리할 별도의 HashMap을 선언한다. 그리고 report를 순회하면서 각 이름마다 신고 횟수를 저장한다.
        4. 다시 report를 순회하면서 k번 이상 신고된 대상을 신고했다면 카운트 시킨다.
        5. result를 반환한다.
        주의할 점은 report에 중복을 제거해야 한다. (HashSet 활용)
    시간 복잡도: O(M + N), M은 id 길이, N은 report 길이
    */
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> ban = new HashMap<>();
        HashSet<String> log = new HashSet<>();
        for (String r : report) {
            log.add(r);
        }
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
            ban.put(id_list[i], 0);
        }
        for (String r : log) {
            String target = r.split(" ")[1];
            ban.put(target, ban.get(target) + 1);
        }
        for (String r : log) {
            String from = r.split(" ")[0];
            String target = r.split(" ")[1];
            if (ban.get(target) >= k) {
                result[map.get(from)] += 1;
            }
        }
        return result;
    }
}
