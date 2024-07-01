package part_03_큐;

import java.util.ArrayDeque;

// 24.06.21 (금)
// 24.07.01 (월) review
public class problem_15_요세푸스_문제 {

    // N명의 사람이 원 형태로 서 있습니다. 각 사람은 1부터 N까지 번호표를 갖고 있습니다. 그리고 임의의 숫자 K가 주어졌을 때 다음과 같이 사람을 없앱니다.
    // 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앱니다.
    // 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다.
    // N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하는 solution() 함수를 구현해주세요.
    // 1 <= N, K <= 1,000, O(N^2) 충분
    /*
    의사 코드
        1. N과 K를 입력받는다.
        2. N개의 크기를 가진 큐를 선언하고, 각각 1부터 N까지 값을 할당한다.
            2-1. 큐를 이용한 근거는 "1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앱니다" 처럼 순차적으로 이용해야 하기 때문이다.
            2-2. 그리고 큐를 이용하면, 제거가 아니라 빼둬야 할 값들을 뒤로 넣을 수 있다. (원형)
        3. 큐의 사이즈가 1이 될 때 까지
            3-1. 큐의 맨 앞 값을 큐의 맨 뒤로 넣는 작업을 K - 1번 동안 반복한다.
            3-2. 큐의 맨 앞을 제거한다.
        시간이 걸린 이유: 타겟이 되는 값을 직접적으로 수정하려고 하였다. 일단 큐를 이용해 맨 앞의 값을 맨 뒤로 넣음으로써 원형 작업을 할 수 있다는 것은 잘 떠올렸다.
        값이 아니라 인덱스 중점으로 생각해보자.
     시간 복잡도: O(N * K)
     */
    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        System.out.println("solve(N, K) = " + solve(N, K));
    }

    public static int solve(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.addLast(i + 1);
        }
        // 시간 복잡도: O(N * K)
        while (queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }
        return queue.pollFirst();
    }
}
