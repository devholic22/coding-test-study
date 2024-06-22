import java.util.HashMap;

public class problem_18_두_개의_수로_특정값_만들기 {

    public static void main(String[] args) {
        System.out.println("solve(new int[]{1, 2, 3, 4, 8}, 6) = " + solve(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println("solve(new int[]{2, 3, 5, 9}, 10) = " + solve(new int[]{2, 3, 5, 9}, 10));
    }

    public static boolean solve(int[] arr, int target) {
        HashMap<Integer, Boolean> numbers = new HashMap<>();
        // 키로써 숫자들을 다 넣어둔다.
        for (int number : arr) {
            numbers.put(number, true);
        }
        for (int number : numbers.keySet()) { // O(N)
            int another = target - number; // number를 골랐다면 대상은 target - number여야 한다.
            if (numbers.containsKey(another) && number != another) { // O(1), 모든 수는 중복되어 있지 않다.
                return true;
            }
        }
        return false; // 여기까지 왔다면 못 구한거다.
    }
}
