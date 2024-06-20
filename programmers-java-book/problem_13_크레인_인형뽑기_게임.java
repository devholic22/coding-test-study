import java.util.ArrayDeque;

// 24.06.20 (목)
public class problem_13_크레인_인형뽑기_게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int move : moves) {
            // move로 이동한 곳에서, 가장 맨 위에 있는 지점을 파악해야 함 (높이)
            int dollHeight = getHeight(board, move);
            if (dollHeight == -1) {
                continue; // 없는 지점일 경우에는 아무 일도 안 생김
            }
            int selectDoll = board[dollHeight][move - 1]; // zero index 고려
            // 그리고 그걸 큐로 옮김
            board[dollHeight][move - 1] = 0; // zero index 고려
            if (!stack.isEmpty() && stack.peekLast() == selectDoll) {
                stack.pollLast();
                answer += 2;
            } else {
                stack.addLast(selectDoll);
            }
        }
        return answer;
    }

    private int getHeight(int[][] board, int position) {
        // N * N 사이즈 board
        int height = board.length;
        // width는 position과 같음, zero index 고려해야 함
        for (int i = 0; i < height; i++) {
            if (board[i][position - 1] != 0) {
                return i;
            }
        }
        return -1; // 없는 경우
    }
}
