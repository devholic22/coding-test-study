import java.util.Arrays;
import java.util.HashMap;

// 24.07.04 (목)
public class problem_27_다단계_칫솔_판매 {

    // 1 <= enroll.length <= 10,000 (enroll.length == referral.length)
    // 1 <= seller.length <= 100,000 (seller.length == amount.length)
    // 수익 단위는 100원 이다.
    /*
    의사 코드
        1. enroll, referral, seller, amount를 입력받는다.
        2. enroll과 referral을 이용하여 트리 관계를 만든다. 완벽한 이진 트리가 아니기에 참조 형태로 만든다.
        3. seller와 amount를 이용하여 수익 계산을 한다.
        4. 계산된 값을 문제에 맞게 반환한다.
    시간 복잡도: O(N * M + NlogN) (부모를 탐색해야 하므로)
    */
    public class Person implements Comparable<Person> {
        String name;
        int index;
        int money;
        Person parent;
        public Person(String name, int index, Person parent) {
            this.name = name;
            this.index = index;
            this.money = 0;
            this.parent = parent;
        }
        public void receive(int amount) {
            int remain = (int) ((double) amount * 0.1);
            if (remain > 0) {
                int mine = amount - remain; // 초반에 틀렸던 이유: mine을 (int) ((double) amount * 0.9)로 했다. amount - remain으로 해야 한다.
                // 예시로 12원을 받았을 경우 기존 방식으로 하면 remain은 1, mine은 10이 되어 버린다. 그러나 이 방식으로 하면 mine은 11이 되어 정상적으로 된다.
                this.money += mine;
                if (this.parent != null) {
                    parent.receive(remain); // 추천자가 있을 경우에만 진행한다. (NPE 방지)
                }
            } else {
                this.money += amount; // remain이 0 이하라면 본인이 다 가진다.
            }
        }
        @Override
        public int compareTo(Person other) { // 결괏값 반환을 위해 정렬 기준 설정
            return Integer.compare(this.index, other.index);
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 이름-사람 맵 관리
        HashMap<String, Person> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new Person(enroll[i], i, map.get(referral[i])));
        }

        // seller 내역을 돌면서 receive 진행
        for (int i = 0; i < seller.length; i++) {
            Person target = map.get(seller[i]);
            target.receive(amount[i] * 100);
        }

        // Person[] to int[], sorting
        Person[] persons = new Person[enroll.length];
        int index = 0;
        for (String key : map.keySet()) {
            persons[index] = map.get(key);
            index++;
        }
        Arrays.sort(persons);
        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = persons[i].money;
        }
        return answer;
    }
}
