import java.util.ArrayDeque;

// 24.06.22 (토)
public class problem_17_카드_뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> stack1 = new ArrayDeque<>();
        ArrayDeque<String> stack2 = new ArrayDeque<>();
        for (String card : cards1) {
            stack1.addLast(card);
        }
        for (String card : cards2) {
            stack2.addLast(card);
        }
        for (int i = 0; i < goal.length; i++) {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return "No";
            }
            if (isValid(goal[i], stack1)) {
                stack1.pollFirst();
            } else if (isValid(goal[i], stack2)) {
                stack2.pollFirst();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
    private boolean isValid(String target, ArrayDeque<String> stack) {
        if (stack.isEmpty()) {
            return false;
        }
        return target.equals(stack.peekFirst());
    }
}
