import java.io.*;
import java.util.ArrayDeque;
// 24.06.30 (일)
public class 스택 {
    // 명령의 수 N : 1 ~ 10,000 -> O(N^2)까지 가능하나, O(N)으로 풀 수 있음
    // 각 명령의 정수는 1 ~ 100,000
    // 명령어: push, pop, size, empty, top
    /*
    의사 코드
        1. N 입력받음
        2. 스택 선언
        3. 명령어 입력 받음
        4. push일 경우
            4-1. 문자열 분할
            4-2. 1번째 값을 정수화한 뒤 스택에 push
        5. pop일 경우
            5-1. 스택이 비어 있으면 -1 출력
            5-2. 스택이 비어 있지 않으면 pop 후 출력
        6. size일 경우
            6-1. stack.size() 출력
        7. empty일 경우
            7-1. stack.isEmpty()일 시 1, 아닐 시 0 출력
        8. top일 경우
            8-1. stack.isEmpty()일 시 -1, 아닐 시 stack.peekLast() 출력
    전체 시간 복잡도: O(N)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = reader.readLine();
            if (command.startsWith("push")) {
                stack.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.pollLast());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else {
                System.out.println(stack.isEmpty() ? -1 : stack.peekLast());
            }
        }
        writer.close();
        reader.close();
    }
}
