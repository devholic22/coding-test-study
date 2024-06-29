package part_01_배열;

// 24.06.16 (일)
// 24.06.29 (토) review
public class problem_05_행렬의_곱셈 {

    // 행렬의 행, 열 각각 2 ~ 100개 사이 -> O(N^2), O(N^3)도 충분 - 최종 시간 복잡도는 O(N^3)
    // 원소는 -10 ~ 20
    // 곱할 수 있는 배열만 주어짐
    /*
    의사 코드
    1. 행렬 두 개를 받는다. 각각 a, b라 한다.
    2. 반환할 행렬을 정의한다. 행렬의 조건에 의해, 반환할 행렬 (이하 c)의 행은 a의 행의 갯수, 열은 b의 열의 갯수여야 한다.
    3. 행렬 c에 값을 할당한다. 행렬 c의 i행 j열의 값은, a의 행 * b의 열을 순차적으로 곱한 뒤 그것의 합산과 같다.
    4. 계산된 행렬을 반환한다.
    */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length; // 행
        int col = arr2[0].length; // 열
        int[][] answer = new int[row][col]; // 반환할 행렬 정의
        for (int i = 0; i < row; i++) { // row는 arr1에 따릅니다. 그렇기에 i는 arr1에 사용됩니다.
            for (int j = 0; j < col; j++) { // col은 arr2에 따릅니다. 그렇기에 j는 arr2에 사용됩니다.
                int sum = 0;
                // arr1의 열과 arr2의 행이 같다는 것을 이용합니다. (행렬의 특성)
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
    /*
    시간 지체 이유
        1. col을 할당할 때 arr2의 열이 아니라 행의 길이로 할당
        2. answer 크기 할당할 때 row와 col 반전하여 저장 - 2차원 배열에서 row는 배열의 길이, col은 각 내부 배열의 길이이다.
    */
}
