import java.util.ArrayDeque;

// 24.06.20 (목)
// 24.06.30 (일) review
public class problem_13_크레인_인형뽑기_게임 {

    // board: 5 x 5 ~ 30 x 30
    // 각각 0 ~ 100 이하 정수
    // moves: 1 ~ 1,000
    // moves 각 원소 1 ~ board 가로 크기 이하
    /*
    의사 코드
        1. board, moves 배열 입력
        2. 스택 선언
        3. 터트린 횟수 저장하는 변수 선언
        3. board를 토대로 col을 추출하는 함수 작성
        4. 특정 col에서 마지막 값을 꺼내는 함수 작성
        5. 스택에 넣기, 같은 값이면 터트리기
        6. 터트린 횟수 변수 반환
    시간 복잡도: O(M * N), M: board 길이, N: moves 길이
    */
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[][] cols = new int[board.length][board.length];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            cols[i] = extract(i, board);
            // System.out.println(Arrays.toString(cols[i]));
        }
        for (int move : moves) {
            // moves가 의미하는 것은 one-index임을 주의
            int val = pick(cols[move - 1]);
            if (val == 0) { // 고른 원소가 없다면 스킵
                continue;
            }
            if (stack.isEmpty()) {
                stack.addLast(val);
            } else {
                // 맨 위의 값과 같았을 경우에는 pop, count += 2
                if (stack.peekLast() == val) {
                    count += 2;
                    stack.pollLast();
                } else { // 그러지 않다면 그냥 push
                    stack.addLast(val);
                }
            }
        }
        return count;
    }
    // int[][] board를 문제에서 쉽게 이용할 수 있게 int[]로 변환합니다.
    public int[] extract(int index, int[][] board) {
        int[] answer = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            answer[i] = board[i][index];
        }
        return answer;
    }
    // 고른 col의 원소들을 검사해가면서 가장 앞에 적재되어 있는 값을 가져오며, 해당 값을 0으로 전환합니다.
    public int pick(int[] col) {
        for (int i = 0; i < col.length; i++) {
            if (col[i] != 0) {
                int x = col[i];
                col[i] = 0;
                return x;
            }
        } // 비어있는 배열이라면 0을 반환합니다.
        return 0;
    }
}
