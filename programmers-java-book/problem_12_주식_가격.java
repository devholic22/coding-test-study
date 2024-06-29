import java.util.ArrayDeque;

// 24.06.19 (수)
public class problem_12_주식_가격 {

    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        stack.addLast(0);

        for (int i = 1; i < answer.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peekLast()]) {
                int idx = stack.pollLast();
                answer[idx] = i - idx;
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pollLast();
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }
}
