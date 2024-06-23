import java.util.HashMap;

// 24.06.23 (일)
public class problem_19_완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            if (map.containsKey(part)) {
                map.put(part, map.get(part) + 1);
            } else {
                map.put(part, 1);
            }
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (String m : map.keySet()) {
            if (map.get(m) > 0) {
                return m;
            }
        }
        return null;
    }
}
