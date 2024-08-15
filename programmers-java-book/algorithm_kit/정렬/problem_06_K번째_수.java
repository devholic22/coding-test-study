package algorithm_kit.정렬;

import java.util.Arrays;

// 24.08.15 (목)
public class problem_06_K번째_수 {

    static int[] arr;

    public int[] solution(int[] array, int[][] commands) {
        // 최종 배열 설정
        arr = new int[array.length];
        int[] answer = new int[commands.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
        for (int i = 0; i < commands.length; i++) {
            answer[i] = logic(commands[i]);
        }
        return answer;
        // 전체 시간 복잡도: O(M * NlogN), N은 array의 길이, M은 commands의 길이
    }
    
    private int logic(int[] command) {
        // [i, j, k] -> i번째부터 j번째까지 선택 후 정렬한 다음 나온 k번째 수
        int[] temp = new int[command[1] - command[0] + 1]; // temp의 길이는 array의 영향을 받음
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i + command[0] - 1];
        }
        Arrays.sort(temp); // 정렬한 다음 반환 O(NlogN)
        return temp[command[2] - 1];
    }
}
