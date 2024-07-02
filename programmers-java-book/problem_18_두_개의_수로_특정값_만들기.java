import java.util.HashMap;

// 24.06.22 (토)
// 24.07.02 (화) review
public class problem_18_두_개의_수로_특정값_만들기 {

    // n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을 때 이 중에서 합이 target인 두 수가 arr에 있는지 찾고, 있으면 true, 없으면 false를 반환하는
    // solution() 함수를 작성하세요.
    // 2 <= n <= 10,000 -> O(N^2) 미만
    // arr의 원소: 1 ~ 10,000, 중복 없음
    // 1 <= target <= 20,000
    /*
    의사 코드
        1. 배열 arr와 target을 받는다.
        2. 해시 맵을 선언한다.
        3. 해시 맵에 배열 arr 원소들을 넣는다.
        4. 해시 맵의 키를 돌면서
            4-1. target - 키 값이 키 모음에 존재한다면 true를 반환한다.
            4-2. 그게 아니라면 false를 반환한다.
        시간 복잡도는 O(N)이 된다. 해시를 이용한 이유는 시간 복잡도를 O(N^2) 미만으로 돌기 위해서는 존재 유무를 파악할 때 최대 O(1) ~ O(logN)이 되어야 하기 때문이다.
     */
    public static void main(String[] args) {
        System.out.println("solve(new int[]{1, 2, 3, 4, 8}, 6) = " + solve(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println("solve(new int[]{2, 3, 5, 9}, 10) = " + solve(new int[]{2, 3, 5, 9}, 10));
    }

    public static boolean solve(int[] arr, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>(); // HashSet으로 해도 동일함
        // O(N)
        for (int number : arr) {
            map.put(number, true);
        }
        // O(N)
        for (int number : map.keySet()) {
            // containsKey = O(1)
            // 이때 target - number와 number가 같으면 안 된다. (테스트 케이스를 참고해보면, [2, 3, 5, 9]가 있고 타겟 값이 10일 때 10 - 5와 5가 같은데 이 경우는 false여야 한다.
            if (map.containsKey(target - number) && target - number != number) {
                return true;
            }
        }
        return false;
    }
}
