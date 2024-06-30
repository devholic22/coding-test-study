import java.util.ArrayDeque;

// 24.06.19 (수)
// 24.06.30 (일) review
public class problem_12_주식_가격 {

    // prices 가격: 1 ~ 10,000
    // prices 길이: 2 ~ 100,000 -> O(N)
    /*
    의사 코드 (시도했던 것)
        1. 주식 가격 prices를 받는다.
        2. prices의 길이만큼에 해당되는 배열을 선언한다.
        3. 스택을 선언한다.
        4. prices를 순회하면서
            4-1. 마지막 인덱스라면 0을 할당한다.
            4-2. 마지막 - 1 인덱스라면 1을 할당한다.
    의사 코드 (실제)
        1. 주식 가격 prices를 받는다.
        2. prices의 길이만큼에 해당되는 배열을 선언한다.
        3. 스택을 선언한다.
        4. prices를 순회하면서
            4-1. 첫 날이라면 인덱스를 스택에 넣는다.
            4-2. 스택이 비어있지 않으면서, 스택의 마지막 날 보다 다음 날이 가격이 떨어진다면 스택의 마지막 날에 해당하는 값을 기간을 계산하여 할당한다. 이때 반복문으로 해야 최대한 제거된다.
            4-3. 기본적으로는 인덱스를 스택에 넣는다.
        5. 이후 스택이 빌 때 까지 날짜들을 계산한다. 스택에 있던 값들은 계속 증가하기만 했던 날이라 마지막 날로부터의 상대적 기간을 넣으면 된다.
        시간 복잡도는 O(N)이 된다.
    */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length - 1; i++) {
            if (i == 0) {
                stack.addLast(i); // 인덱스를 관리하도록 한다. 그리고 처음은 무조건 들어간다.
            } else {
                // 핵심 부분
                // i번째 날이 스택의 맨 마지막 날보다 작다면 떨어진 것
                // ex: 1, 6, 9, 5일 때 [0, 0, 0, 0]이 되고, 스택은 [0, 1, 2]까지 쌓여있을 때, 5의 인덱스인 3을 만나면 인덱스 2를 가진 9보다 작음 - 인덱스 2를 스택에서 제거 및 answer[2] 할당
                // 그 다음으로 스택의 마지막 인덱스는 1, 역시 인덱스 1을 가진 6보다 작으므로 인덱스 1을 스택에서 제거 및 answer[1] 할당
                while (!stack.isEmpty() && prices[i] < prices[stack.peekLast()]) {
                    int j = stack.pollLast();
                    answer[j] = i - j; // 떨어진 날들은 answer에 할당한다.
                }
                stack.addLast(i);
            }
        }
        // 핵심 부분
        // 스택에 남아있던 인덱스들은 계속 오르기만 했던 날
        // 따라서, 맨 마지막 날짜로부터의 상대적 기간을 저장하면 됨
        while (!stack.isEmpty()) {
            int j = stack.pollLast();
            answer[j] = prices.length - 1 - j;
        }
        return answer;
    }
    /*
    틀렸던 이유 (접근하지 못한 이유)
        1. 스택에 인덱스가 아니라 값을 관리하려 했다. 문제에서 구하고자 하는 것은 '기간'이기 때문에 인덱스를 관리해야 한다.
        2. 구체적인 로직을 생각하지 못했다.
    */
}
