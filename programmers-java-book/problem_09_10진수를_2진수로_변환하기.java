import java.util.ArrayDeque;

// 24.06.18 (화)
// 24.06.30 (일) review
public class problem_09_10진수를_2진수로_변환하기 {

    // decimal은 1 ~ 10억 미만 자연수
    /*
    의사 코드
        1. 숫자를 입력받는다.
        2. 기본 메서드를 활용하여 2진수로 변환한다.
        3. 해당 2진수를 반환한다.
     시간 복잡도: O(logN)
     */
    public static void main(String[] args) {
        // 데이터 셋
        int[] numbers = {10, 27, 12345};
        for (int number : numbers) {
            System.out.println("solve(number) = " + solve(number));
            System.out.println("another(number) = " + another(number));
        }
    }

    public static String solve(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    // 또 다른 방법: 스택을 활용 (문제 의도)
    /*
        1. 숫자를 입력받는다.
        2. 스택을 선언한다.
        3. 숫자가 0보다 클 때
            3-1. 스택에 숫자를 2로 나눴을 때의 나머지 값을 넣는다. (ex: 13 % 2 = 1, 6 % 2 = 0, 3 % 2 = 1, 1 % 2 = 1)
            3-2. 숫자를 2로 나눈다.
        4. 스택에 있는 값을 거꾸로 빼서 문자열로 반환한다.
        시간 복잡도: O(logN), StringBuilder 방식 또한 O(logN)
     */
    public static String another(int decimal) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (decimal > 0) {
            stack.addLast(decimal % 2);
            decimal /= 2;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }
}
