import java.util.ArrayList;
import java.util.HashMap;

// 24.06.24 (월)
// 24.07.02 (화) review
public class problem_21_오픈_채팅방 {

    // 1 <= record.length <= 100,000
    // Enter ID nickname
    // Leave ID
    // Change ID nickname
    /*
    의사 코드
        1. record를 입력받는다.
        2. HashMap을 선언한다. 이유는 ID, nickname 구조로 이루어지고 ID가 일종의 해시 키로써 활용되기 적절하기 때문이다.
        3. Enter일 경우
            3.1 HashMap에 ID-nickname 구조로 넣는다.
        4. Leave일 경우
            4.1 그대로 둔다.
        5. Change일 경우
            5.1 ID에 해당하는 닉네임을 바꾼다.
        6. 결과를 반환할 문자열 배열 result를 만든다. 동적으로 들어가므로 ArrayList
        7. Enter였을 경우 들어온 것, Leave였을 경우 나간 것으로 처리하고 최종적으로 반환한다.
    시간 복잡도: O(N)
    */
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
        for (String r : record) {
            String[] tokens = r.split(" ");
            if (r.startsWith("Enter") || r.startsWith("Change")) {
                user.put(tokens[1], tokens[2]);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String r : record) {
            String[] tokens = r.split(" ");
            if (r.startsWith("Enter")) {
                result.add(user.get(tokens[1]) + "님이 들어왔습니다.");
            } else if (r.startsWith("Leave")) {
                result.add(user.get(tokens[1]) + "님이 나갔습니다.");
            }
        }
        return result.stream().map(s -> s).toArray(String[]::new);
    }
}
