package suggestion_bonus;

// 24.06.29 (토)
public class problem_01_배열의_평균값 {

    // numbers의 원소: 0 ~ 1000
    // numbers의 길이: 1 ~ 100
    /*
    의사 코드
        1. numbers 배열을 받음
        2. 숫자 합을 저장해 둘 변수를 선언
        3. numbers를 순차적으로 돌면서 각 값을 숫자 합에 저장
        4. 숫자 합을 numbers 길이로 나눈 (double) 값을 반환
    전체 시간 복잡도는 O(N)
    */
    public double solution(int[] numbers) {
        double answer = 0;
        for (int number : numbers) {
            answer += number;
        }
        return answer / numbers.length;
    }
}
