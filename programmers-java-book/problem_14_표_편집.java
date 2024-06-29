import java.util.ArrayDeque;
import java.util.Arrays;

// 24.06.20 (목)
public class problem_14_표_편집 {

    public String solution(int n, int k, String[] cmd) {
        ArrayDeque<Integer> deleted = new ArrayDeque<>();
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k++;

        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.addLast(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
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
}
