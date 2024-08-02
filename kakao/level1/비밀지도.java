package level1;

// 24.08.02 (금)
public class 비밀지도 {

    // 1 <= n <= 16
    // arr1, arr2 길이 모두 n, 각 지도는 n x n 사이즈
    // 정수 배열 각 원소 0 <= x <= 2^n - 1

    /*
    의사 코드
        1. n, arr1, arr2를 입력받는다.
        2. n번을 돌면서 arr1, arr2의 각 숫자를 이진수로 변환해둔다.
        3. 교집합 계산 할 배열 answer에 값을 저장한다.
            3-1. answer의 줄 별로 진행한다. (n번)
            3-2. arr1, arr2의 각 줄의 각 숫자를 and 연산 처리한 값을 answer의 각 줄의 각 위치에 할당한다.
        4. answer를 반환한다.
        시간 복잡도: O(N^2)
     */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];

        // String format = "%0" + n + "d";

        for (int i = 0; i < n; i++) {
            // 런타임 예외 이유: Integer.parseInt(너무_큰_값_발생_가능하기_때문)
            // String s1 = String.format(format, Integer.parseInt(Integer.toBinaryString(arr1[i])));
            // String s2 = String.format(format, Integer.parseInt(Integer.toBinaryString(arr2[i])));

            String b1 = Integer.toBinaryString(arr1[i]); // Integer.toBinaryString(숫자) 형태를 꼭 기억하자.
            String b2 = Integer.toBinaryString(arr2[i]);
            String s1 = "0".repeat(n - b1.length()) + b1;
            String s2 = "0".repeat(n - b2.length()) + b2;

            binary1[i] = s1;
            binary2[i] = s2;
        }

        inject(answer, binary1, binary2);

        return answer;
    }

    private void inject(String[] answer, String[] binary1, String[] binary2) {
        int n = binary1.length;
        for (int i = 0; i < n; i++) {
            String[] row = new String[n];
            String[] b1 = binary1[i].split("");
            String[] b2 = binary2[i].split("");
            for (int j = 0; j < n; j++) {
                // 모두 다 공백일 경우 공백, 하나라도 벽이면 벽으로 진행
                row[j] = (b1[j].equals("0") && b2[j].equals("0")) ? " " : "#";
            }
            // 각 answer[i] 저장
            answer[i] = String.join("", row);
        }
    }
}
