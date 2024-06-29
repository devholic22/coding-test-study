// 24.06.26 (수)
public class problem_26_예상_대진표 {

    public int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
}
