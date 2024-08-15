package algorithm_kit.정렬;

import java.util.Arrays;

// 24.08.15 (목)
public class problem_08_H_Index {

    public int solution(int[] citations) {
        // citations의 최대 지점까지를 담은 배열 만든다
        int max = 0;
        for (int c : citations) {
            max = Math.max(c, max);
        }
        int[] sorted = new int[max];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted); // O(NlogN)
        int answer = 0;
        for (int i = 0; i < sorted.length; i++) {
            // 차례로 검사
            int h = sorted[i];
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= h) {
                    cnt++;
                }
            }
            // h개 이상 채웠다면 조건 충족됨
            if (cnt >= h) {
                answer = Math.max(answer, h);
            }
        }
        return answer; // 시간 복잡도 O(N^2)
    }
}
