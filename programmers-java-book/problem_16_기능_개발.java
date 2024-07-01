import java.util.ArrayDeque;
import java.util.ArrayList;

// 24.06.21 (금)
// 24.07.01 (월) review
public class problem_16_기능_개발 {

    // 작업의 개수: 100개 이하
    // 작업 진도 1 ~ 100 미만
    // 작업 속도: 100 이하
    /*
    의사 코드
        1. progresses, speeds를 입력받는다.
        2. 큐를 선언한다. 큐가 적합한 이유는 "뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포"되기 때문이다.
        3. 작업이 끝나기까지 남은 일수를 담은 ArrayList를 선언한다.
        4. progress와 speed를 토대로 완료되기까지 얼마나 걸리는지 계산할 메서드를 작성한다.
        5. 각 일수 당 끝난 작업의 갯수를 담아둘 변수를 선언한다.
        6. 큐에서 맨 앞에 있는 작업을 빼오고, 4번 메서드를 통해 시간을 계산한다. 그리고 5번 변수를 +1 한다. (시간만 넣어둬도 된다.)
        7. 새롭게 빼온 작업의 시간이 6번 작업보다 일찍 끝난다면 5번 변수를 +1 하고, 그게 아니라면 새롭게 변수를 선언하고 더한다.
        8. ArrayList를 int[]로 변환하여 반환한다.
    시간 복잡도는 O(N)이 된다.
    */
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            queue.addLast(calculate(progresses[i], speeds[i]));
        }
        while (!queue.isEmpty()) {
            int time = 1;
            int done = queue.pollFirst();
            while (!queue.isEmpty() && queue.peekFirst() <= done) {
                queue.pollFirst();
                time++;
            }
            list.add(time);
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
    public int calculate(int progress, int speed) {
        return (100 - progress) % speed == 0 ? (100 - progress) / speed : (100 - progress) / speed + 1;
    }
}
