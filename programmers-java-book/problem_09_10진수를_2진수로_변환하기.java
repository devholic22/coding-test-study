// 24.06.18 (화)
public class problem_09_10진수를_2진수로_변환하기 {

    public static void main(String[] args) {
        // 10 -> 1010
        // 27 -> 11011
        // 12345 -> 11000000111001
        System.out.println("solve(10) = " + solve(10));
        System.out.println("solve(10) = " + solve(27));
        System.out.println("solve(10) = " + solve(12345));
    }

    public static String solve(int decimal) {
        return Integer.toBinaryString(decimal); // 기본 메서드 이용하면 금방 풀 수 있음
    }
}
