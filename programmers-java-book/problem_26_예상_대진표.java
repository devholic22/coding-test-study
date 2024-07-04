// 24.06.26 (수)
// 24.07.04 (목) review
public class problem_26_예상_대진표 {

    // N: 2^1 ~ 2^20
    // A, B: N 이하 (A != B)
    /*
    의사 코드 (시도한 방법)
        1. n, a, b를 입력 받는다.
        2. 1부터 n까지가 모두 리프 노드로 되어 있어야 하기 때문에 이들의 인덱스를 리프 노드화한다.
        3. a와 b 모두 각각 2로 나눈다. 자식 요소가 부모 요소로 접근하기 위해서는 자신의 인덱스 / 2를 하면 되기 때문이다.
        4. 첫 부모 지점 (0)까지 도달하기까지의 값을 반환한다.
    시간 복잡도: O(logN)
    */
    public int solution(int n, int a, int b) {
        /*
        시도한 방법
        int answer = 0;
        int add = n - 2;
        a += add;
        b += add;
        while (a != b) {
            a /= 2;
            b /= 2;
            answer++;
        }
        return answer;
        */
        // 정답
        int answer = 0;
        while (a != b) {
            // 오른쪽 참가자 번호를 N, 왼쪽 참가자 번호를 N - 1이라 생각 (같은 그룹)
            // N + 1 / 2는 N/2, (N - 1) + 1 / 2 또한 N/2가 됨, 즉 승자는 N/2를 가짐
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}
