import java.util.HashMap;

// 24.06.25 (화)
public class problem_23_신고_결과_받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashMap<String, Integer>> log = new HashMap<>(); // 누가 누굴 신고했는지 (반대로 저장)
        HashMap<String, Boolean> banned = new HashMap<>(); // 각 사람이 정지됐는지
        HashMap<Integer, String> result = new HashMap<>(); // answer 위함
        HashMap<String, Integer> count = new HashMap<>(); // 각 사람이 몇 번 받았는지
        HashMap<String, Integer> receive = new HashMap<>(); // 알림

        // 각 사람마다 신고 내역을 가진다
        int idx = 0;
        for (String id : id_list) {
            log.put(id, new HashMap<String, Integer>());
            banned.put(id, false);
            count.put(id, 0);
            receive.put(id, 0);
            result.put(idx, id);
            idx++;
        }

        // 신고 내역 저장
        for (String r : report) {
            String from = r.split(" ")[0];
            String to = r.split(" ")[1];
            if (log.get(to).containsKey(from)) {
                continue;
            }
            log.get(to).put(from, 1);
            count.put(to, count.get(to) + 1);
        }

        // 정지 여부 마킹
        for (String id : id_list) {
            if (count.get(id) >= k) {
                banned.put(id, true);
                for (String alert : log.get(id).keySet()) {
                    receive.put(alert, receive.get(alert) + 1);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = receive.get(result.get(i));
        }
        return answer;
    }
}
