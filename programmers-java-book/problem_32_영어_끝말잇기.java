import java.util.HashSet;

// 24.08.08 (목)
public class problem_32_영어_끝말잇기 {

    /*
    의사 코드
        1. n, words를 입력받는다.
        2. 반환할 answer와 이용할 set을 초기화한다.
        3. 선택되었던 마지막 단어는 첫 값을 기준으로 초기화한다.
        4. words를 돌면서
            4-1. 사람의 인덱스를 구한다. 예시로 words는 8개, 인원이 3명일 경우에는 0번 인덱스는 1번 사람이 맡아야 한다. 이는 (0 % 3) + 1 = 1로 도출할 수 있다.
            4-2. 단어의 인덱스를 구한다. 특정 사람에게서의 몇 번째인지 알아야 하므로 조금 식이 복잡하다.
            4-3. 만약 마지막 값의 철자로 시작하지 않는다면 answer에 사람과 단어의 인덱스를 담아 반환한다.
            4-4. 만약 이미 쓴 단어를 다시 불렀다면 answer에 사람과 단어의 인덱스를 담아 반환한다.
            4-5. last 단어는 반복문을 돌면서 갱신한다.
        5. answer를 반환한다.
        시간 복잡도는 O(N)이 된다.
        정답률 70% 대의 비교적 쉬운 문제였는데, index를 수식화하는 과정에서 생각보다 오래 걸렸다.
     */
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>(); // HashSet 만으로도 충분해서 선택하였다.
        String last = words[0];
        for (int i = 0; i < words.length; i++) {
            int person = i % n + 1;
            int index = (i % (words.length % 2 == 0 ? words.length : words.length + 1)) / n + 1;
            String s = last.split("")[last.length() - 1];
            if (!words[i].startsWith(s) && i != 0) { // i != 0일 때만 진행
                answer[0] = person;
                answer[1] = index;
                return answer; // [사람, 인덱스] 형태로 반환
            }
            if (set.contains(words[i])) {
                answer[0] = person;
                answer[1] = index;
                return answer; // [사람, 인덱스] 형태로 반환
            } else {
                set.add(words[i]); // 끝말잇기 선택 단어에 add
            }
            last = words[i]; // last 항상 최신화
        }
        return answer;
    }
}
