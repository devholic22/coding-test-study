import java.util.*;
import java.io.*;
// 24.07.01 (월)
public class 큐 {
    // 명령의 수 N: 1 <= N <= 10,000 -> O(N)이 적합
    // 각 정수: 1 ~ 100,000
    /*
    의사 코드
        1. N을 입력받는다.
        2. 큐를 선언한다. (큐를 직접 구현해야 하기 때문)
        3. push X: 큐의 맨 뒤에 X를 넣는다.
        4. pop: 만약 큐가 비어있었다면 -1, 있다면 맨 앞의 값을 제거한 뒤 출력한다.
        5. size: 큐의 사이즈를 출력한다.
        6. empty: 큐가 비어있으면 1, 큐가 비어있지 않으면 0을 출력한다.
        7. front: 큐가 비어있으면 -1, 비어있지 않으면 맨 앞의 값을 출력한다.
        8. back: 큐가 비어있으면 -1, 비어있지 않으면 맨 뒤의 값을 출력한다.
    시간 복잡도: O(N)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = reader.readLine();
            if (command.startsWith("push")) {
                queue.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.pollFirst());
                }
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                String answer = queue.isEmpty() ? "1" : "0";
                System.out.println(answer);
            } else if (command.equals("front")) {
                String answer = queue.isEmpty() ? "-1" : queue.peekFirst() + "";
                System.out.println(answer);
            } else {
                String answer = queue.isEmpty() ? "-1" : queue.peekLast() + "";
                System.out.println(answer);
            }
        }
        reader.close();
    }
}
