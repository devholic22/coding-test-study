import java.util.ArrayDeque;
import java.util.Arrays;

// 24.06.20 (목)
// 24.06.30 (일) review
public class problem_14_표_편집 {

    public String solution(int n, int k, String[] cmd) {
        ArrayDeque<Integer> deleted = new ArrayDeque<>();
        // 양 끝에서 삽입, 삭제가 일어나도 문제가 없어야 하므로 가상의 공간 2개 추가
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        // up, down 위치 기록
        // 예시로 1번째 인덱스는 down을 할 시 2, up을 할 시 0
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        k++; // 가상 공간이 있기 때문에 현재 커서 + 1

        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.addLast(k); // 스택에 담아둔다.
                up[down[k]] = up[k]; // 연결 리스트처럼 연결되도록 한다.
                down[up[k]] = down[k]; // 연결 리스트처럼 연결되도록 한다.
                k = n < down[k] ? up[k] : down[k];
            }
            else if (c.startsWith("Z")) {
                int restore = deleted.pollLast();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
    /*
    틀렸던 이유
        1. ArrayList를 이용하여 직접 값을 remove, add 하려 했다. 편하긴 하지만 O(N)만큼의 부가 작업이 필요하다.
        2. 배열[배열[인덱스]] 형태의 응용을 잘 하지 못했다. 주식 가격 문제의 경우에도 인덱스만 활용되었었다..
     */
}
