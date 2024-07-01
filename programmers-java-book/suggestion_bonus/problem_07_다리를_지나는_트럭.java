package suggestion_bonus;

import java.util.ArrayDeque;
import java.util.Queue;

// 24.07.01 (토)
public class problem_07_다리를_지나는_트럭 {

    // bridge_length를 "다리 길이", "한 번에 건널 수 있는 트럭의 갯수" 두 가지로 생각해야 한다.
    // 1 <= bridge_length <= 10,000
    // 1 <= truck_weights <= 10,000
    // 1 <= 트럭 무게 <= weight
    /*
        의사 코드 (시도했던)
        1. bridge_length, weight, truck_weights를 입력받는다.
        2. 시간 변수를 선언한다.
        3. 큐를 선언한다. 큐를 이용한 근거는 "정해진 순으로 건너려 합니다."가 있기 때문이다.
        4. 큐에 쌓인 트럭의 무게 총합을 관리할 변수를 선언한다.
        5. truck_weights를 순회하면서
            5-1. 큐에 쌓인 트럭의 무게 총합을 관리할 변수를 선언한다.
            5-2. 큐의 사이즈가 bridge_length 이하, 4-1이 weight 이하라면 truck_weight를 넣는다.
            5-3. 넣을 때 2번의 변수를 1 증가시킨다.
            5-4. 이후 순차적으로 큐에서 제거하고, 제거할 때도 2번의 변수를 1 증가시킨다.
        6. 2번 변수를 반환한다.
    시간 복잡도: O(N), N은 truck_weights의 길이
    일단 문제 자체가 설명이 부족했고, 그로 인해 이해를 잘못했다. 일단 큐를 써야 하는 문제임은 파악했으나, 반드시 다시 복습해야 한다.
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 경과 시간
        int totalWeightOnBridge = 0; // 현재 다리 위의 트럭들의 총 무게
        Queue<Integer> bridge = new ArrayDeque<>(); // 다리 위의 트럭들을 관리하는 큐

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0); // 다리 길이만큼 0으로 초기화
        }

        int currentIndex = 0; // 현재 다리를 건너려고 대기 중인 트럭의 인덱스

        while (currentIndex < truck_weights.length || totalWeightOnBridge > 0) {
            time++; // 시간 경과
            totalWeightOnBridge -= bridge.poll(); // 다리 위의 첫 번째 트럭이 다리를 다 건넜으면 큐에서 제거

            if (currentIndex < truck_weights.length) {
                // 다음 트럭이 다리에 진입할 수 있는지 확인
                if (totalWeightOnBridge + truck_weights[currentIndex] <= weight) {
                    bridge.add(truck_weights[currentIndex]); // 트럭을 다리에 올림
                    totalWeightOnBridge += truck_weights[currentIndex]; // 다리 위 총 무게 갱신
                    currentIndex++; // 다음 트럭으로 이동
                } else {
                    bridge.add(0); // 트럭을 올릴 수 없으면 0을 추가하여 시간만 경과시킴
                }
            } else {
                bridge.add(0); // 모든 트럭이 다리를 진입한 후에도 다리의 남은 트럭이 이동하도록 0을 추가
            }
        }

        return time;
    }
}
