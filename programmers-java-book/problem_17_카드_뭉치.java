import java.util.ArrayDeque;

// 24.06.22 (토)
// 24.07.01 (월) review
public class problem_17_카드_뭉치 {

    // 1 <= cards1의 길이, cards2의 길이 <= 10
    // 2 <= goal의 길이 <= cards1의 길이 + cards2의 길이
    // 모두 소문자
    /*
    의사 코드
        1. cards1, cards2, goal을 입력받는다.
        2. cards1, cards2를 각각 큐로 만든다. 근거는 앞에 있는 것들부터 소모되어야 하기 때문이다.
        3. goal의 원소를 순회하면서
            3-1. cards1의 맨 앞, cards2의 맨 앞과 비교한다. 둘 다 해당되지 않을 경우 바로 "No"를 반환한다.
            3-2. goal의 원소와 맞는 게 있다면 맞는 단어를 제거한다.
        4. goal 순회가 끝났다면 "Yes"를 반환한다.
    시간 복잡도: O(N) - 최대 20
    */
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 카드들을 큐로 관리
        ArrayDeque<String> card1 = new ArrayDeque<>();
        ArrayDeque<String> card2 = new ArrayDeque<>();
        for (String card : cards1) {
            card1.addLast(card);
        }
        for (String card : cards2) {
            card2.addLast(card);
        }
        // goal을 순회하면서
        for (String g : goal) {
            // card1의 첫 요소와 같다면 poll (예외 처리)
            if (!card1.isEmpty() && card1.peekFirst().equals(g)) {
                card1.pollFirst();
                // card2의 첫 요소와 같다면 poll (예외 처리)
            } else if (!card2.isEmpty() && card2.peekFirst().equals(g)) {
                card2.pollFirst();
                // 모두 아니라면 불가능함
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
