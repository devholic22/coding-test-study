import java.util.ArrayDeque;

// 24.06.21 (금)
public class problem_15_요세푸스_문제 {

    public static void main(String[] args) {
        System.out.println("solve(5, 2) = " + solve(5, 2));
    }

    public static int solve(int n, int k) {
        ArrayDeque<Integer> store = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            store.addLast(i);
        }

        while (store.size() != 1) {
            // 1번 번호표를 가진 사람을 기준으로 k번째 사람을 제거
            for (int i = 1; i < k; i++) {
                store.addLast(store.pollFirst());
            }
            store.pollFirst();
        }
        // 없앤 사람 다음 사람을 기준으로 다시 k번째 사람을 제거 -> 즉, 하나만 남을 때 까지 계속 반복

        // 마지막에 살아있는 사람의 번호를 반환
        return store.pollFirst();
    }
}
