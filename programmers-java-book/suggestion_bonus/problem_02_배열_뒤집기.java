package suggestion_bonus;

// 24.06.29 (토)
public class problem_02_배열_뒤집기 {

    // num_list의 길이: 1 ~ 1,000
    // num_list의 원소: 0 ~ 1,000
    /*
    의사 코드
        1. num_list를 받는다.
        2. num_list 크기만큼의 배열을 생성한다.
        3. num_list의 처음의 값을 answer의 마지막 값으로 할당하는 식으로 작성한다.
        4. answer를 반환한다.
    전체 시간 복잡도: O(N)
    */
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length - 1 - i]; // 인덱스 오류 방지하기 위해 -1
        }
        return answer;
    }
}
