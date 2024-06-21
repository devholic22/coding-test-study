import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

// 24.06.21 (금)
public class problem_16_기능_개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> store = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int time = calculateDoneDay(progresses[i], speeds[i]); // ex: 7
            map.put(time, 0); // 각각의 time들이 HashMap key로 등록되도록 한다.
            store.addLast(time); // 각각의 time들이 스택에 들어가도록 한다.
        }

        int max = 0;
        for (int key : map.keySet()) { // 최대 일수를 구한다. (ex: 20)
            max = Math.max(max, key);
        }

        for (int day = 0; day <= max; day++) { // 0일째부터 max 일 때 까지 돌면서 해당 일자에 제거할 수 있는지 진행한다.
            int count = 0;
            while (!store.isEmpty() && store.peekFirst() <= day) { // 이때 맨 처음의 값이 day보다 작거나 같을 때에만 진행한다. 또한, 반복문으로 돌린다.
                // 예시로 [10, 5, 3, 15]인 경우 처음 day가 10에 걸리므로 10 <= 10, 5 <= 10, 3 <= 10이 모두 해당된다. 단 15는 10보다 크므로 별도로 된다.
                count++;
                store.pollFirst();
            }
            if (count != 0) { // 무의미한 0은 추가되지 않도록 한다.
                result.add(count);
            }
            count = 0;
        }
        return result.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    private int calculateDoneDay(int progress, int speed) {
        return (100 - progress) % speed == 0 ? (100 - progress) / speed : (100 - progress) / speed + 1;
    }
}
